package com.example.novel;

import cn.hutool.core.util.ObjectUtil;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 基类
 */
public class BaseController<T> {

    public AjaxResult success (Object object,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(ResultContant.SUCCESS_CODE);
        ajaxResult.setData(object);
        ajaxResult.setResult(result);
        return ajaxResult;
    }

    public AjaxResult error (Object object,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(ResultContant.ERROR_CODE);
        ajaxResult.setData(object);
        ajaxResult.setResult(result);
        return ajaxResult;
    }

    public AjaxResult success (int code,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setResult(result);
        return ajaxResult;
    }


    public AjaxResult error (int code,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setResult(result);
        return ajaxResult;
    }


    /**
     * 分页
     */
    public PageTable getTable(List list){
        PageTable<T> table = new PageTable<>();
        PageInfo<T> info = new PageInfo<T>();
        table.setPage(info.getPageNum());
        table.setSize(info.getPageSize());
        table.setTotal(info.getTotal());
        table.setRows(info.getList());
        return table;
    }

    /**
     * 开启分页
     */
    public void startPage(){
        Integer pageNum = ServletRequest.getInteger(PageTable.PAGE_NUM);
        Integer pageSize = ServletRequest.getInteger(PageTable.PAGE_SIZE);
        pageNum = ObjectUtil.isEmpty(pageNum) ? 1 : pageNum;
        pageSize = ObjectUtil.isEmpty(pageSize) ? 1 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
    }
}
