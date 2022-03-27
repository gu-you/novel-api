package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssNovelAssess;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: IBssNovelAssessService
 * @Description: TODO   业务-评论 服务类
 * @date 2022-03-27
 */
public interface IBssNovelAssessService extends IService<BssNovelAssess> {

    /**
     * 业务-评论查询列表
     *
     * @param bssNovelAssess
     * @return BssNovelAssess
     */
    List<BssNovelAssess> selectBssNovelAssessList(BssNovelAssess bssNovelAssess);

    /**
     * 业务-评论详情(单个条目)
     *
     * @param id 主键
     * @return BssNovelAssess
     */
    BssNovelAssess selectBssNovelAssessById(Integer id);

    /**
     * 业务-评论详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssNovelAssess
     */
    List<BssNovelAssess> selectBssNovelAssessByIds(Integer[] ids);

    /**
     * 业务-评论新增
     *
     * @param bssNovelAssess
     * @return
     */
    int insertBssNovelAssess(BssNovelAssess bssNovelAssess);

    /**
     * 业务-评论修改
     *
     * @param bssNovelAssess
     * @return
     */
    int updateBssNovelAssess(BssNovelAssess bssNovelAssess);

    /**
     * 业务-评论删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteBssNovelAssessById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteBssNovelAssessByIds(Integer[] ids);
}
