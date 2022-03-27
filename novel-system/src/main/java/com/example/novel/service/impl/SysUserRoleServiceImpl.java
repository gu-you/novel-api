package com.example.novel.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.novel.domain.SysUserRole;
import com.example.novel.mapper.SysUserRoleMapper;
import com.example.novel.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: SysUserRoleServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public List<SysUserRole> selectUserRoleList(SysUserRole sysUserRole) {
        return sysUserRoleMapper.selectUserRoleList(sysUserRole);
    }
}