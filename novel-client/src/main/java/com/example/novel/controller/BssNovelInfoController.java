package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.BssNovelInfo;
import com.example.novel.domain.PageTable;
import com.example.novel.service.IBssNovelInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelInfoController
 * @Description: TODO   业务-小说详情 服务类
 * @date 2022-03-27
 */
@Api(tags = "业务-小说详情")
@RestController
@RequestMapping("/novel/info")
public class BssNovelInfoController extends BaseController {

    @Autowired
    private IBssNovelInfoService iBssNovelInfoService;

    @GetMapping("/list")
    @ApiOperation(value = "业务-小说详情分页列表", response = BssNovelInfo.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页面", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", dataType = "Integer"),
    })
    public PageTable list(BssNovelInfo bssNovelInfo) {
        startPage();
        List<BssNovelInfo> list = null;
        try {
            list = iBssNovelInfoService.selectBssNovelInfoList(bssNovelInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTable(list);
    }

    @GetMapping("/getInfo/{id}")
    @ApiOperation(value = "业务-小说详情详情(单个条目)", response = BssNovelInfo.class)
    public AjaxResult info(@PathVariable Integer id) {
        try {
            BssNovelInfo bssNovelInfo = iBssNovelInfoService.selectBssNovelInfoById(id);
            return success(bssNovelInfo, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @GetMapping("/getInfos/{ids}")
    @ApiOperation(value = "业务-小说详情详情(多个条目)", response = BssNovelInfo.class)
    public AjaxResult info(@PathVariable Integer[] ids) {
        try {
            List<BssNovelInfo> list = iBssNovelInfoService.selectBssNovelInfoByIds(ids);
            return success(list, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PostMapping
    @ApiOperation(value = "业务-小说详情新增")
    public AjaxResult add(@RequestBody BssNovelInfo bssNovelInfo) {
        try {
            iBssNovelInfoService.insertBssNovelInfo(bssNovelInfo);
            return success(bssNovelInfo, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @PutMapping
    @ApiOperation(value = "业务-小说详情修改")
    public AjaxResult edit(@RequestBody BssNovelInfo bssNovelInfo) {
        try {
            iBssNovelInfoService.updateBssNovelInfo(bssNovelInfo);
            return success(bssNovelInfo, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "业务-小说详情删除(单个条目)")
    public AjaxResult remove(@PathVariable Integer id) {
        try {
            iBssNovelInfoService.deleteBssNovelInfoById(id);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }

    }

    @DeleteMapping(value = "/removes/{ids}")
    @ApiOperation(value = "业务-小说详情删除(多个条目)")
    public AjaxResult removes(@PathVariable Integer[] ids) {
        try {
            iBssNovelInfoService.deleteBssNovelInfoByIds(ids);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }
}
