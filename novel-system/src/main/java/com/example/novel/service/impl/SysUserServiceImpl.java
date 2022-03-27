package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.AdminUserDetails;
import com.example.novel.domain.SysRole;
import com.example.novel.domain.SysUser;
import com.example.novel.exception.BaseException;
import com.example.novel.jwt.JwtTokenUtil;
import com.example.novel.mapper.SysUserMapper;
import com.example.novel.service.ISysRoleService;
import com.example.novel.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author youwenkai
 * @ClassName: SysUserServiceImpl
 * @Description: TODO   系统-用户表 服务实现类
 * @date 2022-03-27
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    public SysUserMapper sysUserMapper;


    /**
     * 系统-用户表查询列表
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser) {
        List<SysUser> list = sysUserMapper.selectSysUserList(sysUser);
        return list;
    }

    /**
     * 系统-用户表详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public SysUser selectSysUserById(Integer id) {
        SysUser result = sysUserMapper.selectSysUserById(id);
        return result;
    }

    /**
     * 系统-用户表详情(多个条目)
     *
     * @param ids 主键数组
     * @return SysUser
     */
    @Override
    public List<SysUser> selectSysUserByIds(Integer[] ids) {
        List<SysUser> result = sysUserMapper.selectSysUserByIds(ids);
        return result;
    }

    /**
     * 系统-用户表新增
     *
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public int insertSysUser(SysUser sysUser) {
        sysUser.setCreateAt(new Date());
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 系统-用户表修改
     *
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public int updateSysUser(SysUser sysUser) {
        sysUser.setUpdateAt(new Date());
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 系统-用户表删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteSysUserById(Integer id) {
        return sysUserMapper.deleteSysUserById(id);
    }

    /**
     * 系统-用户表删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteSysUserByIds(Integer[] ids) {
        return sysUserMapper.deleteSysUserByIds(ids);
    }

    /**
     * 登陆授权token
     * @param userName 用户名
     * @param passWord 密码
     * @return token
     */
    @Override
    public String login(String userName, String passWord) {
        String token = null;
        try {
            SysUser user = sysUserMapper.selectSysUserByUserName(userName);
            if (!passwordEncoder.matches(passWord, user.getPassWord())) {
                throw new BadCredentialsException("密码不正确！");
            }
            List<SysRole> roleList = roleService.selectSysRoleByUserId(user.getUserId());
            //返回当前用户的权限
            AdminUserDetails userDetails = new AdminUserDetails(user, roleList);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            LOGGER.warn("登录异常{}", e.getMessage());
        }
        if (token == null) {
            throw new BaseException(500, "用户名或密码错误");
        }
        return token;
    }

    /**
     * 根据用户名查询用户
     * @param userName 用户名
     * @return SysUser
     */
    @Override
    public SysUser selectSysUserByUserName(String userName) {
        return sysUserMapper.selectSysUserByUserName(userName);
    }
}
