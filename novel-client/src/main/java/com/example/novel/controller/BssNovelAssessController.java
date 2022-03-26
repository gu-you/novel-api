package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelAssess;
import com.example.novel.service.BssNovelAssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author You
 * @ClassName: BssNovelAssessController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Controller
@RequestMapping(value = "/bssNovelAssess")
public class BssNovelAssessController extends BaseController {
    @Autowired
    private BssNovelAssessService bssNovelAssessService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public AjaxResult add(BssNovelAssess bssNovelAssess) {
        try {
            bssNovelAssessService.insert(bssNovelAssess);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public AjaxResult edit(BssNovelAssess bssNovelAssess) {
        try {
            bssNovelAssessService.updateById(bssNovelAssess);
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
            bssNovelAssessService.deleteBatchIds(idList);
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
            BssNovelAssess bssNovelAssess = bssNovelAssessService.selectById(id);
            return success(bssNovelAssess, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    public AjaxResult queryList(BssNovelAssess bssNovelAssess) {
        try {
            EntityWrapper<BssNovelAssess> wrapper = new EntityWrapper<BssNovelAssess>();
            List<BssNovelAssess> list = bssNovelAssessService.selectList(wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
    public AjaxResult queryPageList() {
        try {
            EntityWrapper<BssNovelAssess> wrapper = new EntityWrapper<BssNovelAssess>();
            Page<BssNovelAssess> pg = new Page<BssNovelAssess>(pageNum, pageSize);
            Page<BssNovelAssess> list = bssNovelAssessService.selectPage(pg, wrapper);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}