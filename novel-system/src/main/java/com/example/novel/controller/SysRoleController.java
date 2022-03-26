package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysRole;
import com.example.novel.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author You
 * @ClassName: SysRoleController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/sysRole")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public AjaxResult add(SysRole sysRole) {
        try {
            sysRoleService.insert(sysRole);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public AjaxResult edit(SysRole sysRole) {
        try {
            sysRoleService.updateById(sysRole);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public AjaxResult delete(String ids) {
        //ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        try {
            List<String> idList = StrUtil.split(ids, ',');
            sysRoleService.deleteBatchIds(idList);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public AjaxResult detail(String id) {
        try {
            //ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
            SysRole sysRole = sysRoleService.selectById(id);
            return success(sysRole, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    public AjaxResult queryList(SysRole sysRole) {
        try {
            EntityWrapper<SysRole> wrapper = new EntityWrapper<SysRole>();
            List<SysRole> list = sysRoleService.selectList(wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
    public AjaxResult queryPageList() {
        try {
            EntityWrapper<SysRole> wrapper = new EntityWrapper<SysRole>();
            Page<SysRole> pg = new Page<SysRole>(pageNum, pageSize);
            Page<SysRole> list = sysRoleService.selectPage(pg, wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}