package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.AdminUserDetails;
import com.example.novel.domain.SysRole;
import com.example.novel.domain.SysUser;
import com.example.novel.jwt.JwtTokenUtil;
import com.example.novel.mapper.SysRoleMapper;
import com.example.novel.mapper.SysUserMapper;
import com.example.novel.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author You
 * @ClassName: SysUserServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public SysUser selectSysUserByUserName(String username) {
        return userMapper.selectSysUserByUserName(username);
    }

    /**
     * 用户登陆，成功后返回token
     *
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public String login(String userName, String passWord) {
        String token = null;
        try {
            SysUser user = userMapper.selectSysUserByUserName(userName);
            if (!passwordEncoder.matches(passWord, user.getPassWord())) {
                throw new BadCredentialsException("密码不正确！");
            }
            List<SysRole> roleList = roleMapper.selectSysRoleByUserId(user.getUserId());
            //返回当前用户的权限
            AdminUserDetails userDetails = new AdminUserDetails(user, roleList);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            LOGGER.warn("登录异常{}", e.getMessage());
        }
        return token;
    }
}