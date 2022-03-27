package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询列表
     * @param sysRole
     * @return
     */
    List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 获取当前用户id所拥有的权限
     * @param userId
     * @return
     */
    List<SysRole> selectSysRoleByUserId(@Param("userId") Integer userId);
}