package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssReadHistory;
import com.example.novel.domain.PageTable;
import com.example.novel.service.IBssReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssReadHistoryController
 * @Description: TODO   阅读历史 服务类
 * @date 2022-03-27
 */
@Api(tags = "阅读历史")
@RestController
@RequestMapping("/read/history")
public class BssReadHistoryController extends BaseController {

    @Autowired
    private IBssReadHistoryService iBssReadHistoryService;

    @GetMapping("/list")
    @ApiOperation(value = "阅读历史分页列表", response = BssReadHistory.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(BssReadHistory bssReadHistory) {
        startPage();
        List<BssReadHistory> list = null;
        try {
            list = iBssReadHistoryService.selectBssReadHistoryList(bssReadHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "阅读历史详情(单个条目)", response = BssReadHistory.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            BssReadHistory bssReadHistory = iBssReadHistoryService.selectBssReadHistoryById(id);
            return success(bssReadHistory, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "阅读历史详情(多个条目)", response = BssReadHistory.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<BssReadHistory> list = iBssReadHistoryService.selectBssReadHistoryByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "阅读历史新增")
    public AjaxResult add(@RequestBody BssReadHistory bssReadHistory) {
        try {
            iBssReadHistoryService.insertBssReadHistory(bssReadHistory);
            return success(bssReadHistory, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "阅读历史修改")
    public AjaxResult edit(@RequestBody BssReadHistory bssReadHistory) {
        try {
            iBssReadHistoryService.updateBssReadHistory(bssReadHistory);
            return success(bssReadHistory, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "阅读历史删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iBssReadHistoryService.deleteBssReadHistoryById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "阅读历史删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iBssReadHistoryService.deleteBssReadHistoryByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
