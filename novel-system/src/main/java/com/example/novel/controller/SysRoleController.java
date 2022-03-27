package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.PageTable;
import com.example.novel.domain.SysRole;
import com.example.novel.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author You
 * @ClassName: SysRoleController
 * @Description: 系统角色
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/sys/role")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysRole sysRole) {
        try {
            sysRoleService.save(sysRole);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody SysRole sysRole) {
        try {
            sysRoleService.updateById(sysRole);
            return success(sysRole,ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping("/del/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        try {
            sysRoleService.removeByIds(Arrays.asList(ids));
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfo/{id}")
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public AjaxResult detail(@PathVariable Integer id) {
        try {
            SysRole sysRole = sysRoleService.getById(id);
            return success(sysRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(SysRole sysRole) {
        startPage();
        List<SysRole> list = null;
        try {
            list = sysRoleService.selectSysRoleList(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }
}