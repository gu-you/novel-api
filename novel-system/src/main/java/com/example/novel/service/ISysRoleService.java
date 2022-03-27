package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.SysRole;

import java.util.List;


/**
 * @author youwenkai
 * @ClassName: ISysRoleService
 * @Description: TODO   系统-权限 服务类
 * @date 2022-03-27
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 系统-权限查询列表
     *
     * @param sysRole
     * @return SysRole
     */
    List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 系统-权限详情(单个条目)
     *
     * @param id 主键
     * @return SysRole
     */
    SysRole selectSysRoleById(Integer id);

    /**
     * 系统-权限详情(多个条目)
     *
     * @param ids 主键数组
     * @return SysRole
     */
    List<SysRole> selectSysRoleByIds(Integer[] ids);

    /**
     * 系统-权限新增
     *
     * @param sysRole
     * @return
     */
    int insertSysRole(SysRole sysRole);

    /**
     * 系统-权限修改
     *
     * @param sysRole
     * @return
     */
    int updateSysRole(SysRole sysRole);

    /**
     * 系统-权限删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteSysRoleById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteSysRoleByIds(Integer[] ids);

    /**
     * 根据用户id查询用户所拥有的权限
     * @param userId 用户id
     * @return
     */
    List<SysRole> selectSysRoleByUserId(Integer userId);
}
