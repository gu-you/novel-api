package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssNovelSort;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: IBssNovelSortService
 * @Description: TODO   业务-小说分类 服务类
 * @date 2022-03-27
 */
public interface IBssNovelSortService extends IService<BssNovelSort> {

    /**
     * 业务-小说分类查询列表
     *
     * @param bssNovelSort
     * @return BssNovelSort
     */
    List<BssNovelSort> selectBssNovelSortList(BssNovelSort bssNovelSort);

    /**
     * 业务-小说分类详情(单个条目)
     *
     * @param id 主键
     * @return BssNovelSort
     */
    BssNovelSort selectBssNovelSortById(Integer id);

    /**
     * 业务-小说分类详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssNovelSort
     */
    List<BssNovelSort> selectBssNovelSortByIds(Integer[] ids);

    /**
     * 业务-小说分类新增
     *
     * @param bssNovelSort
     * @return
     */
    int insertBssNovelSort(BssNovelSort bssNovelSort);

    /**
     * 业务-小说分类修改
     *
     * @param bssNovelSort
     * @return
     */
    int updateBssNovelSort(BssNovelSort bssNovelSort);

    /**
     * 业务-小说分类删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteBssNovelSortById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteBssNovelSortByIds(Integer[] ids);
}
