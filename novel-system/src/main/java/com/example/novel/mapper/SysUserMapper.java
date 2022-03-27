package com.example.novel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.novel.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询sysUser列表
     * @param sysUser
     * @return
     */
    List<SysUser> selectSysUserList(SysUser sysUser);

}