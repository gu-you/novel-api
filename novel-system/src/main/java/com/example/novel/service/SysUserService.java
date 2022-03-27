package com.example.novel.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.novel.domain.SysRole;
import com.example.novel.domain.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: SysUserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> selectSysUserList(SysUser sysUser);

}