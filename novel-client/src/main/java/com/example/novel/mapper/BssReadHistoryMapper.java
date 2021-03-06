package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.BssReadHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssReadHistoryMapper
 * @Description: TODO   阅读历史 持久层
 * @date 2022-03-27
 */
@Mapper
public interface BssReadHistoryMapper extends BaseMapper<BssReadHistory> {

    /**
     * 阅读历史查询列表
     *
     * @param bssReadHistory
     * @return BssReadHistory
     */
    List<BssReadHistory> selectBssReadHistoryList(BssReadHistory bssReadHistory);

    /**
     * 阅读历史详情(单个条目)
     *
     * @param id 主键
     * @return BssReadHistory
     */
    BssReadHistory selectBssReadHistoryById(Integer id);

    /**
     * 阅读历史详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssReadHistory
     */
    List<BssReadHistory> selectBssReadHistoryByIds(Integer[] ids);

    /**
     * 阅读历史新增
     *
     * @param bssReadHistory
     * @return
     */
    int insertBssReadHistory(BssReadHistory bssReadHistory);

    /**
     * 阅读历史修改
     *
     * @param bssReadHistory
     * @return
     */
    int updateBssReadHistory(BssReadHistory bssReadHistory);

    /**
     * 阅读历史删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    int deleteBssReadHistoryById(Integer id);

    /**
     * 删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    int deleteBssReadHistoryByIds(Integer[] ids);


}

