package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssCommentType;
import com.example.novel.domain.PageTable;
import com.example.novel.service.IBssCommentTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssCommentTypeController
 * @Description: TODO   业务-评论分类 服务类
 * @date 2022-03-27
 */
@Api(tags = "业务-评论分类")
@RestController
@RequestMapping("/comment/type")
public class BssCommentTypeController extends BaseController {

    @Autowired
    private IBssCommentTypeService iBssCommentTypeService;

    @GetMapping("/list")
    @ApiOperation(value = "业务-评论分类分页列表", response = BssCommentType.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(BssCommentType bssCommentType) {
        startPage();
        List<BssCommentType> list = null;
        try {
            list = iBssCommentTypeService.selectBssCommentTypeList(bssCommentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "业务-评论分类详情(单个条目)", response = BssCommentType.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            BssCommentType bssCommentType = iBssCommentTypeService.selectBssCommentTypeById(id);
            return success(bssCommentType, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "业务-评论分类详情(多个条目)", response = BssCommentType.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<BssCommentType> list = iBssCommentTypeService.selectBssCommentTypeByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "业务-评论分类新增")
    public AjaxResult add(@RequestBody BssCommentType bssCommentType) {
        try {
            iBssCommentTypeService.insertBssCommentType(bssCommentType);
            return success(bssCommentType, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "业务-评论分类修改")
    public AjaxResult edit(@RequestBody BssCommentType bssCommentType) {
        try {
            iBssCommentTypeService.updateBssCommentType(bssCommentType);
            return success(bssCommentType, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "业务-评论分类删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iBssCommentTypeService.deleteBssCommentTypeById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "业务-评论分类删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iBssCommentTypeService.deleteBssCommentTypeByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
