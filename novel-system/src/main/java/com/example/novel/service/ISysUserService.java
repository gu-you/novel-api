package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.SysUser;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: ISysUserService
 * @Description: TODO   系统-用户表 服务类
 * @date 2022-03-27
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 系统-用户表查询列表
     *
     * @param sysUser
     * @return SysUser
     */
    List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 系统-用户表详情(单个条目)
     *
     * @param id 主键
     * @return SysUser
     */
    SysUser selectSysUserById(Integer id);

    /**
     * 系统-用户表详情(多个条目)
     *
     * @param ids 主键数组
     * @return SysUser
     */
    List<SysUser> selectSysUserByIds(Integer[] ids);

    /**
     * 系统-用户表新增
     *
     * @param sysUser
     * @return
     */
    int insertSysUser(SysUser sysUser);

    /**
     * 系统-用户表修改
     *
     * @param sysUser
     * @return
     */
    int updateSysUser(SysUser sysUser);

    /**
     * 系统-用户表删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteSysUserById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteSysUserByIds(Integer[] ids);

    /**
     * 登陆授权token
     * @param userName 用户名
     * @param passWord 密码
     * @return token
     */
    String login(String userName, String passWord);

    /**
     * 根据用户名查询用户
     * @param userName 用户名
     * @return SysUser
     */
    SysUser selectSysUserByUserName(String userName);
}
