package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.SysRole;
import com.example.novel.mapper.SysRoleMapper;
import com.example.novel.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author youwenkai
 * @ClassName: SysRoleServiceImpl
 * @Description: TODO   系统-权限 服务实现类
 * @date 2022-03-27
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    public SysRoleMapper sysRoleMapper;


    /**
     * 系统-权限查询列表
     *
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole) {
        List<SysRole> list = sysRoleMapper.selectSysRoleList(sysRole);
        return list;
    }

    /**
     * 系统-权限详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public SysRole selectSysRoleById(Integer id) {
        SysRole result = sysRoleMapper.selectSysRoleById(id);
        return result;
    }

    /**
     * 系统-权限详情(多个条目)
     *
     * @param ids 主键数组
     * @return SysRole
     */
    @Override
    public List<SysRole> selectSysRoleByIds(Integer[] ids) {
        List<SysRole> result = sysRoleMapper.selectSysRoleByIds(ids);
        return result;
    }

    /**
     * 系统-权限新增
     *
     * @param sysRole
     * @return
     */
    @Override
    @Transactional
    public int insertSysRole(SysRole sysRole) {
        sysRole.setCreateAt(new Date());
        return sysRoleMapper.insertSysRole(sysRole);
    }

    /**
     * 系统-权限修改
     *
     * @param sysRole
     * @return
     */
    @Override
    @Transactional
    public int updateSysRole(SysRole sysRole) {
        sysRole.setUpdateAt(new Date());
        return sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 系统-权限删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteSysRoleById(Integer id) {
        return sysRoleMapper.deleteSysRoleById(id);
    }

    /**
     * 系统-权限删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteSysRoleByIds(Integer[] ids) {
        return sysRoleMapper.deleteSysRoleByIds(ids);
    }

    /**
     * 根据用户id查询用户所拥有的权限
     * @param userId 用户id
     * @return
     */
    @Override
    public List<SysRole> selectSysRoleByUserId(Integer userId) {
        return sysRoleMapper.selectSysRoleByUserId(userId);
    }
}
