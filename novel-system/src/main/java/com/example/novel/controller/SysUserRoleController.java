package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.PageTable;
import com.example.novel.domain.SysUserRole;
import com.example.novel.service.ISysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: SysUserRoleController
 * @Description: TODO   系统-用户权限关联表 服务类
 * @date 2022-03-27
 */
@Api(tags = "系统-用户权限关联表")
@RestController
@RequestMapping("/user/role")
public class SysUserRoleController extends BaseController {

    @Autowired
    private ISysUserRoleService iSysUserRoleService;

    @GetMapping("/list")
    @ApiOperation(value = "系统-用户权限关联表分页列表", response = SysUserRole.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer")
    })
    public PageTable list(SysUserRole sysUserRole) {
        startPage();
        List<SysUserRole> list = null;
        try {
            list = iSysUserRoleService.selectSysUserRoleList(sysUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "系统-用户权限关联表详情(单个条目)", response = SysUserRole.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            SysUserRole sysUserRole = iSysUserRoleService.selectSysUserRoleById(id);
            return success(sysUserRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "系统-用户权限关联表详情(多个条目)", response = SysUserRole.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<SysUserRole> list = iSysUserRoleService.selectSysUserRoleByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "系统-用户权限关联表新增")
    public AjaxResult add(@RequestBody SysUserRole sysUserRole) {
        try {
            iSysUserRoleService.insertSysUserRole(sysUserRole);
            return success(sysUserRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "系统-用户权限关联表修改")
    public AjaxResult edit(@RequestBody SysUserRole sysUserRole) {
        try {
            iSysUserRoleService.updateSysUserRole(sysUserRole);
            return success(sysUserRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "系统-用户权限关联表删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iSysUserRoleService.deleteSysUserRoleById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "系统-用户权限关联表删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iSysUserRoleService.deleteSysUserRoleByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
