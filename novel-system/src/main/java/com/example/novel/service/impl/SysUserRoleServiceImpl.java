package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.SysUserRole;
import com.example.novel.mapper.SysUserRoleMapper;
import com.example.novel.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author youwenkai
 * @ClassName: SysUserRoleServiceImpl
 * @Description: TODO   系统-用户权限关联表 服务实现类
 * @date 2022-03-27
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Autowired
    public SysUserRoleMapper sysUserRoleMapper;


    /**
     * 系统-用户权限关联表查询列表
     *
     * @param sysUserRole
     * @return
     */
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole) {
        List<SysUserRole> list = sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
        return list;
    }

    /**
     * 系统-用户权限关联表详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public SysUserRole selectSysUserRoleById(Integer id) {
        SysUserRole result = sysUserRoleMapper.selectSysUserRoleById(id);
        return result;
    }

    /**
     * 系统-用户权限关联表详情(多个条目)
     *
     * @param ids 主键数组
     * @return SysUserRole
     */
    @Override
    public List<SysUserRole> selectSysUserRoleByIds(Integer[] ids) {
        List<SysUserRole> result = sysUserRoleMapper.selectSysUserRoleByIds(ids);
        return result;
    }

    /**
     * 系统-用户权限关联表新增
     *
     * @param sysUserRole
     * @return
     */
    @Override
    @Transactional
    public int insertSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insertSysUserRole(sysUserRole);
    }

    /**
     * 系统-用户权限关联表修改
     *
     * @param sysUserRole
     * @return
     */
    @Override
    @Transactional
    public int updateSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 系统-用户权限关联表删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteSysUserRoleById(Integer id) {
        return sysUserRoleMapper.deleteSysUserRoleById(id);
    }

    /**
     * 系统-用户权限关联表删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteSysUserRoleByIds(Integer[] ids) {
        return sysUserRoleMapper.deleteSysUserRoleByIds(ids);
    }
}
