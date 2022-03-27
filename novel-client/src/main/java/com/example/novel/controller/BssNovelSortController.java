package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelSort;
import com.example.novel.service.BssNovelSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: BssNovelSortController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/bssNovelSort")
public class BssNovelSortController extends BaseController {
    @Autowired
    private BssNovelSortService bssNovelSortService;


    @PostMapping("/add")
    public AjaxResult add(@RequestBody BssNovelSort bssNovelSort) {
        try {
            bssNovelSortService.insert(bssNovelSort);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody BssNovelSort bssNovelSort) {
        try {
            bssNovelSortService.updateById(bssNovelSort);
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
            bssNovelSortService.deleteBatchIds(idList);
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
            BssNovelSort bssNovelSort = bssNovelSortService.selectById(id);
            return success(bssNovelSort, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(BssNovelSort bssNovelSort) {
        startPage();
        List<BssNovelSort> list = null;
        try {
            list = bssNovelSortService.selectBssNovelSortList(bssNovelSort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }
}