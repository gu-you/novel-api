package com.example.novel.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.SysRole;
import com.example.novel.mapper.SysRoleMapper;
import com.example.novel.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: SysRoleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 查询列表
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole) {
        return roleMapper.selectSysRoleList(sysRole);
    }

    /**
     * 获取当前用户id所拥有的权限
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> selectSysRoleByUserId(Integer userId) {
        return roleMapper.selectSysRoleByUserId(userId);
    }
}