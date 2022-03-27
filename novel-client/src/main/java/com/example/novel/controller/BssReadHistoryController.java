// package com.example.novel.controller;
//
// import cn.hutool.core.util.StrUtil;
// import com.baomidou.mybatisplus.mapper.EntityWrapper;
// import com.baomidou.mybatisplus.plugins.Page;
// import com.example.novel.BaseController;
// import com.example.novel.contant.ResultContant;
// import com.example.novel.domain.AjaxResult;
// import com.example.novel.domain.BssReadHistory;
// import com.example.novel.service.BssReadHistoryService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
//
// import java.util.List;
//
// /**
//  * @author You
//  * @ClassName: BssReadHistoryController
//  * @Description: TODO(这里用一句话描述这个类的作用)
//  * @date 2022-03-26
//  */
// @Controller
// @RequestMapping(value = "/bssReadHistory")
// public class BssReadHistoryController extends BaseController {
//     @Autowired
//     private BssReadHistoryService bssReadHistoryService;
//
//     @RequestMapping(method = RequestMethod.POST, value = "/add")
//     public AjaxResult add(BssReadHistory bssReadHistory) {
//         try {
//             bssReadHistoryService.insert(bssReadHistory);
//             return success(200, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.POST, value = "/edit")
//     public AjaxResult edit(BssReadHistory bssReadHistory) {
//         try {
//             bssReadHistoryService.updateById(bssReadHistory);
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
//             bssReadHistoryService.deleteBatchIds(idList);
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
//             BssReadHistory bssReadHistory = bssReadHistoryService.selectById(id);
//             return success(bssReadHistory, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
//
//     @RequestMapping(method = RequestMethod.GET, value = "/queryList")
//     public AjaxResult queryList(BssReadHistory bssReadHistory) {
//         try {
//             EntityWrapper<BssReadHistory> wrapper = new EntityWrapper<BssReadHistory>();
//             List<BssReadHistory> list = bssReadHistoryService.selectList(wrapper);
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
//             EntityWrapper<BssReadHistory> wrapper = new EntityWrapper<BssReadHistory>();
//             Page<BssReadHistory> pg = new Page<BssReadHistory>(1, 10);
//             Page<BssReadHistory> list = bssReadHistoryService.selectPage(pg, wrapper);
//             return success(list, ResultContant.SUCCESS);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return error(500, ResultContant.ERROR);
//         }
//     }
// }