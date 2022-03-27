package com.example.novel.exception;

import com.example.novel.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);


    /**
     * 处理自定义异常
     */
    @ExceptionHandler(BaseException.class)
    public AjaxResult handleCustomException(BaseException ex) {
        AjaxResult result = new AjaxResult();
        result.setCode(ex.getCode());
        result.setResult(ex.getMsg());
        return result;
    }

    /**
     * 处理与数据库交互异常
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public AjaxResult handleDuplicateKeyException(DuplicateKeyException ex) {
        AjaxResult result = new AjaxResult();
        result.setCode(500);
        result.setResult(ex.getMessage());
        return result;
    }

    /**
     * 处理全局异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception ex) {
        AjaxResult result = new AjaxResult();
        result.setCode(500);
        result.setResult(ex.getMessage());
        logger.error(ex.getMessage(), ex);
        return result;
    }
}
