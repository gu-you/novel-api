package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelInfo;
import com.example.novel.service.BssNovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: BssNovelInfoController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/bssNovelInfo")
public class BssNovelInfoController extends BaseController {
    @Autowired
    private BssNovelInfoService bssNovelInfoService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody BssNovelInfo bssNovelInfo) {
        try {
            bssNovelInfoService.insert(bssNovelInfo);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody BssNovelInfo bssNovelInfo) {
        try {
            bssNovelInfoService.updateById(bssNovelInfo);
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
            bssNovelInfoService.deleteBatchIds(idList);
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
            BssNovelInfo bssNovelInfo = bssNovelInfoService.selectById(id);
            return success(bssNovelInfo, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(@RequestBody BssNovelInfo bssNovelInfo) {
        startPage();
        List<BssNovelInfo> list = null;
        try {
            list = bssNovelInfoService.selectBssNovelInfoList(bssNovelInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

}