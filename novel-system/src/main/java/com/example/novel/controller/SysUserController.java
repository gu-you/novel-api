package com.example.novel.controller;

import com.example.novel.BaseController;
import com.example.novel.PageTable;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysRole;
import com.example.novel.domain.SysUser;
import com.example.novel.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author You
 * @ClassName: SysUserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/sys/user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public AjaxResult add(SysUser sysUser) {
        try {
            sysUserService.save(sysUser);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    // @RequestMapping(method = RequestMethod.POST, value = "/edit")
    // public AjaxResult edit(SysUser SysUser) {
    //     try {
    //         sysUserService.updateById(SysUser);
    //         return success(200, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    // public AjaxResult delete(String ids) {
    //     //ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
    //     try {
    //         List<String> idList = StrUtil.split(ids, ',');
    //         sysUserService.deleteBatchIds(idList);
    //         return success(200, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/detail")
    // public AjaxResult detail(String id) {
    //     try {
    //         //ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
    //         SysUser sysUser = sysUserService.selectById(id);
    //         return success(sysUser, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    // public AjaxResult queryList(SysUser sysUser) {
    //     try {
    //         EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
    //         List<SysUser> list = sysUserService.selectList(wrapper);
    //         return success(list, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
    // public AjaxResult queryPageList() {
    //     try {
    //         EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
    //         Page<SysUser> pg = new Page<SysUser>(1, 10);
    //         Page<SysUser> list = sysUserService.selectPage(pg, wrapper);
    //         return success(list, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
}