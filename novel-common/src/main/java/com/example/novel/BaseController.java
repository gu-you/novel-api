package com.example.novel;

import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;

/**
 * 基类
 */
public class BaseController {

    public static final Integer pageNum = null;
    public static final Integer pageSize = null;


    public static AjaxResult success (Object object,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(ResultContant.SUCCESS_CODE);
        ajaxResult.setData(object);
        ajaxResult.setResult(result);
        return ajaxResult;
    }

    public static AjaxResult error (Object object,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(ResultContant.ERROR_CODE);
        ajaxResult.setData(object);
        ajaxResult.setResult(result);
        return ajaxResult;
    }

    public static AjaxResult success (int code,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setResult(result);
        return ajaxResult;
    }


    public static AjaxResult error (int code,String result){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setCode(code);
        ajaxResult.setResult(result);
        return ajaxResult;
    }

}
