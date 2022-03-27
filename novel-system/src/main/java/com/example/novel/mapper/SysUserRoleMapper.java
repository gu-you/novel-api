package com.example.novel.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.novel.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 查询用户角色表列表
     * @param userRole
     * @return
     */
    List<SysUserRole> selectUserRoleList(SysUserRole userRole);
}