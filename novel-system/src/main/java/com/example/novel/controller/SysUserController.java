package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysRole;
import com.example.novel.domain.SysUser;
import com.example.novel.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: SysUserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */

@RestController
@RequestMapping(value = "/SysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysUser sysUser) {
        try {
            sysUserService.insert(sysUser);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody SysUser SysUser) {
        try {
            sysUserService.updateById(SysUser);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping("/del/{ids}")
    public AjaxResult delete(@PathVariable String ids) {
        //ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        try {
            List<String> idList = StrUtil.split(ids, ',');
            sysUserService.deleteBatchIds(idList);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfo/{id}")
    public AjaxResult detail(@PathVariable String id) {
        try {
            //ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
            SysUser sysUser = sysUserService.selectById(id);
            return success(sysUser, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(SysUser sysUser) {
        startPage();
        List<SysUser> list = null;
        try {
            list = sysUserService.selectSysUserList(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

}