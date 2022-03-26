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
import com.example.novel.com.example.novel.entity.BssNovelSort;
        import org.springframework.stereotype.Controller;
            import com.example.novel.base.BaseController;
    import com.example.novel.com.example.novel.service.impl.BssNovelSortService;

import cn.hutool.core.util.StrUtil;

/**
 *
 * @ClassName: BssNovelSortController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/bssNovelSort")
public class BssNovelSortController extends BaseController<BssNovelSort> {
@Autowired
private BssNovelSortService bssNovelSortService;

@RequestMapping(method = RequestMethod.POST, value = "/add")
public void add(BssNovelSort bssNovelSort, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(bssNovelSort, AddGroup.class);
    bssNovelSortService.insert(bssNovelSort);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/edit")
public void edit(BssNovelSort bssNovelSort, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(bssNovelSort, EditGroup.class);
    bssNovelSortService.updateById(bssNovelSort);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/delete")
public void delete(HttpServletRequest request, HttpServletResponse response,
        String ids) {
        ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        List<String> idList = StrUtil.split(ids, ',');
    bssNovelSortService.deleteBatchIds(idList);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.GET, value = "/detail")
public void detail(HttpServletRequest request, HttpServletResponse response,
        String id) {
        ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
    BssNovelSort bssNovelSort = bssNovelSortService.selectById(id);
        renderResult(response, RestResultGenerator.success(bssNovelSort));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryList")
public void queryList(HttpServletRequest request, HttpServletResponse response) {
        EntityWrapper<BssNovelSort> wrapper = new EntityWrapper<BssNovelSort>();
        List<BssNovelSort> list = bssNovelSortService.selectList(wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
public void queryPageList(HttpServletRequest request, HttpServletResponse response,
        BaseQuery query) {
        beanValidator(query, PageGroup.class);
        EntityWrapper<BssNovelSort> wrapper = new EntityWrapper<BssNovelSort>();
        Page<BssNovelSort> pg = new Page<BssNovelSort>(query.getPage(), query.getRows());
        Page<BssNovelSort> list = bssNovelSortService.selectPage(pg, wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }
        }