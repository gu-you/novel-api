package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssCommentType;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: IBssCommentTypeService
 * @Description: TODO   业务-评论分类 服务类
 * @date 2022-03-27
 */
public interface IBssCommentTypeService extends IService<BssCommentType> {

    /**
     * 业务-评论分类查询列表
     *
     * @param bssCommentType
     * @return BssCommentType
     */
    List<BssCommentType> selectBssCommentTypeList(BssCommentType bssCommentType);

    /**
     * 业务-评论分类详情(单个条目)
     *
     * @param id 主键
     * @return BssCommentType
     */
    BssCommentType selectBssCommentTypeById(Integer id);

    /**
     * 业务-评论分类详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssCommentType
     */
    List<BssCommentType> selectBssCommentTypeByIds(Integer[] ids);

    /**
     * 业务-评论分类新增
     *
     * @param bssCommentType
     * @return
     */
    int insertBssCommentType(BssCommentType bssCommentType);

    /**
     * 业务-评论分类修改
     *
     * @param bssCommentType
     * @return
     */
    int updateBssCommentType(BssCommentType bssCommentType);

    /**
     * 业务-评论分类删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteBssCommentTypeById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteBssCommentTypeByIds(Integer[] ids);
}
