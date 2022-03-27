package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelAssess;
import com.example.novel.domain.PageTable;
import com.example.novel.service.IBssNovelAssessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelAssessController
 * @Description: TODO   业务-评论 服务类
 * @date 2022-03-27
 */
@Api(tags = "业务-评论")
@RestController
@RequestMapping("/novel/assess")
public class BssNovelAssessController extends BaseController {

    @Autowired
    private IBssNovelAssessService iBssNovelAssessService;

    @GetMapping("/list")
    @ApiOperation(value = "业务-评论分页列表", response = BssNovelAssess.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(BssNovelAssess bssNovelAssess) {
        startPage();
        List<BssNovelAssess> list = null;
        try {
            list = iBssNovelAssessService.selectBssNovelAssessList(bssNovelAssess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "业务-评论详情(单个条目)", response = BssNovelAssess.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            BssNovelAssess bssNovelAssess = iBssNovelAssessService.selectBssNovelAssessById(id);
            return success(bssNovelAssess, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "业务-评论详情(多个条目)", response = BssNovelAssess.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<BssNovelAssess> list = iBssNovelAssessService.selectBssNovelAssessByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "业务-评论新增")
    public AjaxResult add(@RequestBody BssNovelAssess bssNovelAssess) {
        try {
            iBssNovelAssessService.insertBssNovelAssess(bssNovelAssess);
            return success(bssNovelAssess, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "业务-评论修改")
    public AjaxResult edit(@RequestBody BssNovelAssess bssNovelAssess) {
        try {
            iBssNovelAssessService.updateBssNovelAssess(bssNovelAssess);
            return success(bssNovelAssess, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "业务-评论删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iBssNovelAssessService.deleteBssNovelAssessById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "业务-评论删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iBssNovelAssessService.deleteBssNovelAssessByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
