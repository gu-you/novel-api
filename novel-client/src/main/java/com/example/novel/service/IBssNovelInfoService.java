package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssNovelInfo;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: IBssNovelInfoService
 * @Description: TODO   业务-小说详情 服务类
 * @date 2022-03-27
 */
public interface IBssNovelInfoService extends IService<BssNovelInfo> {

    /**
     * 业务-小说详情查询列表
     *
     * @param bssNovelInfo
     * @return BssNovelInfo
     */
    List<BssNovelInfo> selectBssNovelInfoList(BssNovelInfo bssNovelInfo);

    /**
     * 业务-小说详情详情(单个条目)
     *
     * @param id 主键
     * @return BssNovelInfo
     */
    BssNovelInfo selectBssNovelInfoById(Integer id);

    /**
     * 业务-小说详情详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssNovelInfo
     */
    List<BssNovelInfo> selectBssNovelInfoByIds(Integer[] ids);

    /**
     * 业务-小说详情新增
     *
     * @param bssNovelInfo
     * @return
     */
    int insertBssNovelInfo(BssNovelInfo bssNovelInfo);

    /**
     * 业务-小说详情修改
     *
     * @param bssNovelInfo
     * @return
     */
    int updateBssNovelInfo(BssNovelInfo bssNovelInfo);

    /**
     * 业务-小说详情删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteBssNovelInfoById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteBssNovelInfoByIds(Integer[] ids);
}
