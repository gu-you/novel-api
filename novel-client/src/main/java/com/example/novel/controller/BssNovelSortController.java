package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelSort;
import com.example.novel.domain.PageTable;
import com.example.novel.service.IBssNovelSortService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelSortController
 * @Description: TODO   业务-小说分类 服务类
 * @date 2022-03-27
 */
@Api(tags = "业务-小说分类")
@RestController
@RequestMapping("/novel/sort")
public class BssNovelSortController extends BaseController {

    @Autowired
    private IBssNovelSortService iBssNovelSortService;

    @GetMapping("/list")
    @ApiOperation(value = "业务-小说分类分页列表", response = BssNovelSort.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(BssNovelSort bssNovelSort) {
        startPage();
        List<BssNovelSort> list = null;
        try {
            list = iBssNovelSortService.selectBssNovelSortList(bssNovelSort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "业务-小说分类详情(单个条目)", response = BssNovelSort.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            BssNovelSort bssNovelSort = iBssNovelSortService.selectBssNovelSortById(id);
            return success(bssNovelSort, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "业务-小说分类详情(多个条目)", response = BssNovelSort.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<BssNovelSort> list = iBssNovelSortService.selectBssNovelSortByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "业务-小说分类新增")
    public AjaxResult add(@RequestBody BssNovelSort bssNovelSort) {
        try {
            iBssNovelSortService.insertBssNovelSort(bssNovelSort);
            return success(bssNovelSort, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "业务-小说分类修改")
    public AjaxResult edit(@RequestBody BssNovelSort bssNovelSort) {
        try {
            iBssNovelSortService.updateBssNovelSort(bssNovelSort);
            return success(bssNovelSort, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "业务-小说分类删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iBssNovelSortService.deleteBssNovelSortById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "业务-小说分类删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iBssNovelSortService.deleteBssNovelSortByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
