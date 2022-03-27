package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.SysUserRole;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: ISysUserRoleService
 * @Description: TODO   系统-用户权限关联表 服务类
 * @date 2022-03-27
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    /**
     * 系统-用户权限关联表查询列表
     *
     * @param sysUserRole
     * @return SysUserRole
     */
    List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

    /**
     * 系统-用户权限关联表详情(单个条目)
     *
     * @param id 主键
     * @return SysUserRole
     */
    SysUserRole selectSysUserRoleById(Integer id);

    /**
     * 系统-用户权限关联表详情(多个条目)
     *
     * @param ids 主键数组
     * @return SysUserRole
     */
    List<SysUserRole> selectSysUserRoleByIds(Integer[] ids);

    /**
     * 系统-用户权限关联表新增
     *
     * @param sysUserRole
     * @return
     */
    int insertSysUserRole(SysUserRole sysUserRole);

    /**
     * 系统-用户权限关联表修改
     *
     * @param sysUserRole
     * @return
     */
    int updateSysUserRole(SysUserRole sysUserRole);

    /**
     * 系统-用户权限关联表删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteSysUserRoleById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteSysUserRoleByIds(Integer[] ids);
}
