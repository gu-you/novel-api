package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.BssNovelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelInfoMapper
 * @Description: TODO   业务-小说详情 持久层
 * @date 2022-03-27
 */
@Mapper
public interface BssNovelInfoMapper extends BaseMapper<BssNovelInfo> {

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

