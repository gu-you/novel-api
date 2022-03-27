package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelAssess;
import com.example.novel.service.BssNovelAssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: BssNovelAssessController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/bssNovelAssess")
public class BssNovelAssessController extends BaseController {
    @Autowired
    private BssNovelAssessService bssNovelAssessService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody BssNovelAssess bssNovelAssess) {
        try {
            bssNovelAssessService.insert(bssNovelAssess);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody BssNovelAssess bssNovelAssess) {
        try {
            bssNovelAssessService.updateById(bssNovelAssess);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping("/del/{ids}")
    public AjaxResult delete(@PathVariable String ids) {
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

    @GetMapping("/getInfo/{id}")
    public AjaxResult detail(@PathVariable String id) {
        try {
            //ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
            BssNovelAssess bssNovelAssess = bssNovelAssessService.selectById(id);
            return success(bssNovelAssess, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(@RequestBody BssNovelAssess bssNovelAssess) {
        startPage();
        List<BssNovelAssess> list = null;
        try {
            list = bssNovelAssessService.selectBssNovelAssessList(bssNovelAssess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }
}