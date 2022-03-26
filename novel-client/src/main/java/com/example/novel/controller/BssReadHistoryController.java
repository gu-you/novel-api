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
import com.example.novel.com.example.novel.entity.BssReadHistory;
        import org.springframework.stereotype.Controller;
            import com.example.novel.base.BaseController;
    import com.example.novel.com.example.novel.service.impl.BssReadHistoryService;

import cn.hutool.core.util.StrUtil;

/**
 *
 * @ClassName: BssReadHistoryController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/bssReadHistory")
public class BssReadHistoryController extends BaseController<BssReadHistory> {
@Autowired
private BssReadHistoryService bssReadHistoryService;

@RequestMapping(method = RequestMethod.POST, value = "/add")
public void add(BssReadHistory bssReadHistory, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(bssReadHistory, AddGroup.class);
    bssReadHistoryService.insert(bssReadHistory);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/edit")
public void edit(BssReadHistory bssReadHistory, HttpServletRequest request,
        HttpServletResponse response) {
        beanValidator(bssReadHistory, EditGroup.class);
    bssReadHistoryService.updateById(bssReadHistory);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.POST, value = "/delete")
public void delete(HttpServletRequest request, HttpServletResponse response,
        String ids) {
        ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
        List<String> idList = StrUtil.split(ids, ',');
    bssReadHistoryService.deleteBatchIds(idList);
        renderResult(response);
        }

@RequestMapping(method = RequestMethod.GET, value = "/detail")
public void detail(HttpServletRequest request, HttpServletResponse response,
        String id) {
        ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
    BssReadHistory bssReadHistory = bssReadHistoryService.selectById(id);
        renderResult(response, RestResultGenerator.success(bssReadHistory));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryList")
public void queryList(HttpServletRequest request, HttpServletResponse response) {
        EntityWrapper<BssReadHistory> wrapper = new EntityWrapper<BssReadHistory>();
        List<BssReadHistory> list = bssReadHistoryService.selectList(wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }

@RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
public void queryPageList(HttpServletRequest request, HttpServletResponse response,
        BaseQuery query) {
        beanValidator(query, PageGroup.class);
        EntityWrapper<BssReadHistory> wrapper = new EntityWrapper<BssReadHistory>();
        Page<BssReadHistory> pg = new Page<BssReadHistory>(query.getPage(), query.getRows());
        Page<BssReadHistory> list = bssReadHistoryService.selectPage(pg, wrapper);
        renderResult(response, RestResultGenerator.success(list));
        }
        }