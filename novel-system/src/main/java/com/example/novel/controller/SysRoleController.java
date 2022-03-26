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
import com.example.novel.com.example.novel.entity.SysRole;
        import org.springframework.stereotype.Controller;
            import com.example.novel.base.BaseController;
    import com.example.novel.com.example.novel.service.impl.SysRoleService;

import cn.hutool.core.util.StrUtil;

/**
 *
 * @ClassName: SysRoleController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/sysRole")
public class SysRoleController extends BaseController{
@Autowired
private SysRoleService sysRoleService;

@RequestMapping(method = RequestMethod.POST, value = "/add")
public void add(SysRole sysRole, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(sysRole, AddGroup.class);
    sysRoleService.insert(sysRole);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/edit")
public void edit(SysRole sysRole, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(sysRole, EditGroup.class);
    sysRoleService.updateById(sysRole);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/delete")
public void delete(HttpServletRequest request, HttpServletResponse response,
        String ids) {
        ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        List<String> idList = StrUtil.split(ids, ',');
    sysRoleService.deleteBatchIds(idList);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.GET, value = "/detail")
public void detail(HttpServletRequest request, HttpServletResponse response,
        String id) {
        ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
    SysRole sysRole = sysRoleService.selectById(id);
        renderResult(response, RestResultGenerator.success(sysRole));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryList")
public void queryList(HttpServletRequest request, HttpServletResponse response) {
        EntityWrapper<SysRole> wrapper = new EntityWrapper<SysRole>();
        List<SysRole> list = sysRoleService.selectList(wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
public void queryPageList(HttpServletRequest request, HttpServletResponse response,
        BaseQuery query) {
        beanValidator(query, PageGroup.class);
        EntityWrapper<SysRole> wrapper = new EntityWrapper<SysRole>();
        Page<SysRole> pg = new Page<SysRole>(query.getPage(), query.getRows());
        Page<SysRole> list = sysRoleService.selectPage(pg, wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }
        }