package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.PageTable;
import com.example.novel.domain.SysUser;
import com.example.novel.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: SysUserController
 * @Description: TODO   系统-用户表 服务类
 * @date 2022-03-27
 */
@Api(tags = "系统-用户表")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping("/list")
    @ApiOperation(value = "系统-用户表分页列表", response = SysUser.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(SysUser sysUser) {
        startPage();
        List<SysUser> list = null;
        try {
            list = iSysUserService.selectSysUserList(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "系统-用户表详情(单个条目)", response = SysUser.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            SysUser sysUser = iSysUserService.selectSysUserById(id);
            return success(sysUser, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "系统-用户表详情(多个条目)", response = SysUser.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<SysUser> list = iSysUserService.selectSysUserByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "系统-用户表新增")
    public AjaxResult add(@RequestBody SysUser sysUser) {
        try {
            iSysUserService.insertSysUser(sysUser);
            return success(sysUser, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "系统-用户表修改")
    public AjaxResult edit(@RequestBody SysUser sysUser) {
        try {
            iSysUserService.updateSysUser(sysUser);
            return success(sysUser, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "系统-用户表删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iSysUserService.deleteSysUserById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "系统-用户表删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iSysUserService.deleteSysUserByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
