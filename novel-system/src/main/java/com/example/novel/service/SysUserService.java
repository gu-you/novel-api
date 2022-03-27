package com.example.novel.service;
import com.baomidou.mybatisplus.extension.service.IService;
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

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    SysUser selectSysUserByUserName(String username);

    /**
     * 用户登陆，成功后返回token
     * @param userName
     * @param passWord
     * @return
     */
    String login(String userName, String passWord);
}