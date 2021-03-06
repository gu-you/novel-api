package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.BssNovelSort;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelSortMapper
 * @Description: TODO   业务-小说分类 持久层
 * @date 2022-03-27
 */
@Mapper
public interface BssNovelSortMapper extends BaseMapper<BssNovelSort> {

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

