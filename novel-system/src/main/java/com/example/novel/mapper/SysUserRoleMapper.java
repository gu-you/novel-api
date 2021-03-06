package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: SysUserRoleMapper
 * @Description: TODO   系统-用户权限关联表 持久层
 * @date 2022-03-27
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

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

