package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelSort;
import com.example.novel.service.BssNovelSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author You
 * @ClassName: BssNovelSortController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/bssNovelSort")
public class BssNovelSortController extends BaseController {
    @Autowired
    private BssNovelSortService bssNovelSortService;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public AjaxResult add(BssNovelSort bssNovelSort) {
        try {
            bssNovelSortService.insert(bssNovelSort);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public AjaxResult edit(BssNovelSort bssNovelSort) {
        try {
            bssNovelSortService.updateById(bssNovelSort);
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
            bssNovelSortService.deleteBatchIds(idList);
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
            BssNovelSort bssNovelSort = bssNovelSortService.selectById(id);
            return success(bssNovelSort, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    public AjaxResult queryList(BssNovelSort bssNovelSort) {
        try {
            EntityWrapper<BssNovelSort> wrapper = new EntityWrapper<BssNovelSort>();
            List<BssNovelSort> list = bssNovelSortService.selectList(wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
    public AjaxResult queryPageList() {
        try {
            EntityWrapper<BssNovelSort> wrapper = new EntityWrapper<BssNovelSort>();
            Page<BssNovelSort> pg = new Page<BssNovelSort>(pageNum, pageSize);
            Page<BssNovelSort> list = bssNovelSortService.selectPage(pg, wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}