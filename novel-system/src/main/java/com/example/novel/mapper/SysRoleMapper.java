package com.example.novel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.novel.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询列表
     * @param sysRole
     * @return
     */
    List<SysRole> selectSysRoleList(SysRole sysRole);
}