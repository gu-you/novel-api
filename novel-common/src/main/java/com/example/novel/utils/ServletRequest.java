package com.example.novel.utils;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class ServletRequest{

    /**
     * 获取路径参数
     */
    public static Integer getInteger(String param){
        Object data = getRequest().getAttribute(param);
        if(ObjectUtil.isNotEmpty(data)) {
            try {
                return Integer.parseInt(data.toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
    * 获取httpServletRequest
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

}
