package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysUser;
import com.example.novel.service.SysUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping
@RestController
public class SysLoginController extends BaseController {
    @Autowired
    private SysUserService sysUserService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody SysUser sysUser) {
        String token = sysUserService.login(sysUser.getUserName(), sysUser.getPassWord());
        if (token == null) {
            return error(500,"用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return success(tokenMap,"登录成功");
    }
}
