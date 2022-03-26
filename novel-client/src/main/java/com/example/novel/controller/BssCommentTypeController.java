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
import com.example.novel.com.example.novel.entity.BssCommentType;
        import org.springframework.stereotype.Controller;
            import com.example.novel.base.BaseController;
    import com.example.novel.com.example.novel.service.impl.BssCommentTypeService;

import cn.hutool.core.util.StrUtil;

/**
 *
 * @ClassName: BssCommentTypeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/bssCommentType")
public class BssCommentTypeController extends BaseController {
@Autowired
private BssCommentTypeService bssCommentTypeService;

@RequestMapping(method = RequestMethod.POST, value = "/add")
public void add(BssCommentType bssCommentType, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(bssCommentType, AddGroup.class);
    bssCommentTypeService.insert(bssCommentType);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/edit")
public void edit(BssCommentType bssCommentType, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(bssCommentType, EditGroup.class);
    bssCommentTypeService.updateById(bssCommentType);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/delete")
public void delete(HttpServletRequest request, HttpServletResponse response,
        String ids) {
        ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        List<String> idList = StrUtil.split(ids, ',');
    bssCommentTypeService.deleteBatchIds(idList);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.GET, value = "/detail")
public void detail(HttpServletRequest request, HttpServletResponse response,
        String id) {
        ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
    BssCommentType bssCommentType = bssCommentTypeService.selectById(id);
        renderResult(response, RestResultGenerator.success(bssCommentType));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryList")
public void queryList(HttpServletRequest request, HttpServletResponse response) {
        EntityWrapper<BssCommentType> wrapper = new EntityWrapper<BssCommentType>();
        List<BssCommentType> list = bssCommentTypeService.selectList(wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
public void queryPageList(HttpServletRequest request, HttpServletResponse response,
        BaseQuery query) {
        beanValidator(query, PageGroup.class);
        EntityWrapper<BssCommentType> wrapper = new EntityWrapper<BssCommentType>();
        Page<BssCommentType> pg = new Page<BssCommentType>(query.getPage(), query.getRows());
        Page<BssCommentType> list = bssCommentTypeService.selectPage(pg, wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }
        }