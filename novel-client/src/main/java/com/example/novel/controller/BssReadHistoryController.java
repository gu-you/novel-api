package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssReadHistory;
import com.example.novel.service.BssReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: BssReadHistoryController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/bssReadHistory")
public class BssReadHistoryController extends BaseController {
    @Autowired
    private BssReadHistoryService bssReadHistoryService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody BssReadHistory bssReadHistory) {
        try {
            bssReadHistoryService.insert(bssReadHistory);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody BssReadHistory bssReadHistory) {
        try {
            bssReadHistoryService.updateById(bssReadHistory);
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
            bssReadHistoryService.deleteBatchIds(idList);
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
            BssReadHistory bssReadHistory = bssReadHistoryService.selectById(id);
            return success(bssReadHistory, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(@RequestBody BssReadHistory bssReadHistory) {
        // STOPSHIP: 2022/3/26
        startPage();
        List<BssReadHistory> list = null;
        try {
            list = bssReadHistoryService.selectBssReadHistoryList(bssReadHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

}