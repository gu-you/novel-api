package com.example.novel.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysUserRole;
import com.example.novel.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: SysUserRoleController
 * @Description: TODO 角色用户关联
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/sysUserRole")
public class SysUserRoleController extends BaseController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysUserRole sysUserRole) {
        try {
            sysUserRoleService.insert(sysUserRole);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody SysUserRole sysUserRole) {
        try {
            sysUserRoleService.updateById(sysUserRole);
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
            sysUserRoleService.deleteBatchIds(idList);
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
            SysUserRole sysUserRole = sysUserRoleService.selectById(id);
            return success(sysUserRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(SysUserRole sysUserRole) {
        startPage();
        List<SysUserRole> list = null;
        try {
            list = sysUserRoleService.selectUserRoleList(sysUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

}