package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.SysRole;

import java.util.List;

/**
 *
 * @ClassName: SysRoleService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 查询列表数据
     * @param sysRole
     * @return
     */
    List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 获取当前用户id所拥有的权限
     * @param userId
     * @return
     */
    List<SysRole> selectSysRoleByUserId(Integer userId);
}