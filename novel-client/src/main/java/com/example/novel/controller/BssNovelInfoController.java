// package com.example.novel.controller;
//
// import cn.hutool.core.util.StrUtil;
// import com.baomidou.mybatisplus.mapper.EntityWrapper;
// import com.baomidou.mybatisplus.plugins.Page;
// import com.example.novel.BaseController;
// import com.example.novel.contant.ResultContant;
// import com.example.novel.domain.AjaxResult;
// import com.example.novel.domain.BssNovelInfo;
// import com.example.novel.service.BssNovelInfoService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
//
// import java.util.List;
//
// /**
//  * @author You
//  * @ClassName: BssNovelInfoController
//  * @Description: TODO(这里用一句话描述这个类的作用)
//  * @date 2022-03-26
//  */
// @Controller
// @RequestMapping(value = "/bssNovelInfo")
// public class BssNovelInfoController extends BaseController {
//     @Autowired
//     private BssNovelInfoService bssNovelInfoService;
//
//     @RequestMapping(method = RequestMethod.POST, value = "/add")
//     public AjaxResult add(BssNovelInfo bssNovelInfo) {
//         try {
//             bssNovelInfoService.insert(bssNovelInfo);
//             return success(200, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.POST, value = "/edit")
//     public AjaxResult edit(BssNovelInfo bssNovelInfo) {
//         try {
//             bssNovelInfoService.updateById(bssNovelInfo);
//             return success(200, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//     public AjaxResult delete(String ids) {
//         //ValidateUtil.isNotBlank(ids, "主键参数非法，操作失败，请检查");
//         try {
//             List<String> idList = StrUtil.split(ids, ',');
//             bssNovelInfoService.deleteBatchIds(idList);
//             return success(200, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.GET, value = "/detail")
//     public AjaxResult detail(String id) {
//         try {
//             //ValidateUtil.isNotBlank(id, "主键参数非法，操作失败，请检查");
//             BssNovelInfo bssNovelInfo = bssNovelInfoService.selectById(id);
//             return success(bssNovelInfo, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.GET, value = "/queryList")
//     public AjaxResult queryList(BssNovelInfo bssNovelInfo) {
//         try {
//             EntityWrapper<BssNovelInfo> wrapper = new EntityWrapper<BssNovelInfo>();
//             List<BssNovelInfo> list = bssNovelInfoService.selectList(wrapper);
//             return success(list, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.GET, value = "/queryPageList")
//     public AjaxResult queryPageList() {
//         try {
//             EntityWrapper<BssNovelInfo> wrapper = new EntityWrapper<BssNovelInfo>();
//             Page<BssNovelInfo> pg = new Page<BssNovelInfo>(1, 10);
//             Page<BssNovelInfo> list = bssNovelInfoService.selectPage(pg, wrapper);
//             return success(list, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
// }
