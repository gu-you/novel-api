package com.example.novel.controller;


import com.example.novel.BaseController;
import com.example.novel.contant.ResultContant;
import com.example.novel.domain.AjaxResult;
import com.example.novel.domain.SysUserRole;
import com.example.novel.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author You
 * @ClassName: SysUserRoleController
 * @Description: TODO 角色用户关联
 * @date 2022-03-26
 */
@RestController
@RequestMapping(value = "/sysUserRole")
public class SysUserRoleController extends BaseController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    // @RequestMapping(method = RequestMethod.POST, value = "/add")
    // public AjaxResult add(SysUserRole sysUserRole) {
    //     try {
    //         sysUserRoleService.i(sysUserRole);
    //         return success(200, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }

    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody SysUserRole sysUserRole) {
        try {
            sysUserRoleService.updateById(sysUserRole);
            return success(200, ResultContant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return error(500, ResultContant.ERROR);
        }
    }

    // @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    // public AjaxResult delete(String ids) {
    //     //ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
    //     try {
    //         List<String> idList = StrUtil.split(ids, ',');
    //         sysUserRoleService.deleteBatchIds(idList);
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
    //         SysUserRole sysUserRole = sysUserRoleService.selectById(id);
    //         return success(sysUserRole, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
    //
    // @RequestMapping(method = RequestMethod.GET, value = "/queryList")
    // public AjaxResult queryList(SysUserRole sysUserRole) {
    //     try {
    //         EntityWrapper<SysUserRole> wrapper = new EntityWrapper<SysUserRole>();
    //         List<SysUserRole> list = sysUserRoleService.selectList(wrapper);
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
    //         EntityWrapper<SysUserRole> wrapper = new EntityWrapper<SysUserRole>();
    //         Page<SysUserRole> pg = new Page<SysUserRole>(1, 10);
    //         Page<SysUserRole> list = sysUserRoleService.selectPage(pg, wrapper);
    //         return success(list, ResultContant.SUCCESS);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return error(500, ResultContant.ERROR);
    //     }
    // }
}