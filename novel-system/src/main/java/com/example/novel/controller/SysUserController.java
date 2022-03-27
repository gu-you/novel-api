package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysUser;
import com.example.novel.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author You
 * @ClassName: SysUserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/sys/user")
@Api(tags = "用户管理",description = "针对于用户操作")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/add")
    @ApiOperation("新增用户｜｜用户注册")
    public AjaxResult add(@RequestBody SysUser sysUser) {
        sysUser.setPassWord(passwordEncoder.encode(sysUser.getPassWord()));
        try {
            sysUserService.save(sysUser);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public AjaxResult edit(SysUser SysUser) {
        try {
            sysUserService.updateById(SysUser);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public AjaxResult delete(Integer[] ids) {
        try {
            sysUserService.removeByIds(Arrays.asList(ids));
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public AjaxResult detail(String id) {
        try {
            SysUser sysUser = sysUserService.getById(id);
            return success(sysUser, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    public AjaxResult queryList(SysUser sysUser) {
        try {
            EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
            List<SysUser> list = sysUserService.s(wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}