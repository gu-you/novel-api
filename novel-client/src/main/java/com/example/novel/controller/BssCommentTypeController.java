package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssCommentType;
import com.example.novel.service.BssCommentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    //
    // @RequestMapping(method = RequestMethod.POST, value = "/add")
    // public AjaxResult add(BssCommentType bssCommentType) {
    //     try {
    //         bssCommentTypeService.insert(bssCommentType);
    //         return success(200, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }

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

    // @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    // public AjaxResult delete(String ids) {
    //     //ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
    //     try {
    //         List<String> idList = StrUtil.split(ids, ',');
    //         bssCommentTypeService.deleteBatchIds(idList);
    //         return success(200, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/detail")
    // public AjaxResult detail(String id) {
    //     try {
    //         //ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
    //         BssCommentType bssCommentType = bssCommentTypeService.selectById(id);
    //         return success(bssCommentType, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    // public AjaxResult queryList(BssCommentType bssCommentType) {
    //     try {
    //         EntityWrapper<BssCommentType> wrapper = new EntityWrapper<BssCommentType>();
    //         List<BssCommentType> list = bssCommentTypeService.selectList(wrapper);
    //         return success(list, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
    // public AjaxResult queryPageList() {
    //     try {
    //         EntityWrapper<BssCommentType> wrapper = new EntityWrapper<BssCommentType>();
    //         Page<BssCommentType> pg = new Page<BssCommentType>(1, 10);
    //         Page<BssCommentType> list = bssCommentTypeService.selectPage(pg, wrapper);
    //         return success(list, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
}