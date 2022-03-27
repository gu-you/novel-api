package com.example.novel.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssCommentType;
import com.example.novel.service.BssCommentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author You
 * @ClassName: BssCommentTypeController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/bssCommentType")
public class BssCommentTypeController extends BaseController {
    @Autowired
    private BssCommentTypeService bssCommentTypeService;

    @PostMapping("/add")
    public AjaxResult add(@RequestBody BssCommentType bssCommentType) {
        try {
            bssCommentTypeService.insert(bssCommentType);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody BssCommentType bssCommentType) {
        try {
            bssCommentTypeService.updateById(bssCommentType);
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
            bssCommentTypeService.deleteBatchIds(idList);
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
            BssCommentType bssCommentType = bssCommentTypeService.selectById(id);
            return success(bssCommentType, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/list")
    public PageTable queryList(@RequestBody BssCommentType bssCommentType) {
        startPage();
        List<BssCommentType> list = null;
        try {
            list = bssCommentTypeService.selectBssCommentTypeList(bssCommentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

}