package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.PageTable;
import com.example.novel.domain.SysRole;
import com.example.novel.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: SysRoleController
 * @Description: TODO   系统-权限 服务类
 * @date 2022-03-27
 */
@Api(tags = "系统-权限")
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService iSysRoleService;

    @GetMapping("/list")
    @ApiOperation(value = "系统-权限分页列表", response = SysRole.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(SysRole sysRole) {
        startPage();
        List<SysRole> list = null;
        try {
            list = iSysRoleService.selectSysRoleList(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "系统-权限详情(单个条目)", response = SysRole.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            SysRole sysRole = iSysRoleService.selectSysRoleById(id);
            return success(sysRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "系统-权限详情(多个条目)", response = SysRole.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<SysRole> list = iSysRoleService.selectSysRoleByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "系统-权限新增")
    public AjaxResult add(@RequestBody SysRole sysRole) {
        try {
            iSysRoleService.insertSysRole(sysRole);
            return success(sysRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "系统-权限修改")
    public AjaxResult edit(@RequestBody SysRole sysRole) {
        try {
            iSysRoleService.updateSysRole(sysRole);
            return success(sysRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "系统-权限删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iSysRoleService.deleteSysRoleById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "系统-权限删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iSysRoleService.deleteSysRoleByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
