package com.example.novel.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.glens.eap.platform.entity.RestResultGenerator;
import com.glens.eap.platform.beanvalidator.AddGroup;
import com.glens.eap.platform.beanvalidator.EditGroup;
import com.glens.eap.platform.beanvalidator.PageGroup;
import com.glens.spider.base.BaseQuery;
import com.glens.eap.platform.util.ValidateUtil;
import com.example.novel.com.example.novel.entity.SysUser;
import org.springframework.stereotype.Controller;
import com.example.novel.base.BaseController;
import com.example.novel.com.example.novel.service.impl.SysUserService;

import cn.hutool.core.util.StrUtil;

/**
 * @author You
 * @ClassName: SysUserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController extends BaseController<SysUser> {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(SysUser sysUser, HttpServletRequest request,
                    HttpServletResponse response) {
        beanValidator(sysUser, AddGroup.class);
        sysUserService.insert(sysUser);
        renderResult(response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public void edit(SysUser sysUser, HttpServletRequest request,
                     HttpServletResponse response) {
        beanValidator(sysUser, EditGroup.class);
        sysUserService.updateById(sysUser);
        renderResult(response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response,
                       String ids) {
        ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        List<String> idList = StrUtil.split(ids, ',');
        sysUserService.deleteBatchIds(idList);
        renderResult(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public void detail(HttpServletRequest request, HttpServletResponse response,
                       String id) {
        ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
        SysUser sysUser = sysUserService.selectById(id);
        renderResult(response, RestResultGenerator.success(sysUser));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    public void queryList(HttpServletRequest request, HttpServletResponse response) {
        EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
        List<SysUser> list = sysUserService.selectList(wrapper);
        renderResult(response, RestResultGenerator.success(list));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
    public void queryPageList(HttpServletRequest request, HttpServletResponse response,
                              BaseQuery query) {
        beanValidator(query, PageGroup.class);
        EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
        Page<SysUser> pg = new Page<SysUser>(query.getPage(), query.getRows());
        Page<SysUser> list = sysUserService.selectPage(pg, wrapper);
        renderResult(response, RestResultGenerator.success(list));
    }
}