package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.BssNovelAssess;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelAssessMapper
 * @Description: TODO   业务-评论 持久层
 * @date 2022-03-27
 */
@Mapper
public interface BssNovelAssessMapper extends BaseMapper<BssNovelAssess> {

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

