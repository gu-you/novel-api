package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssNovelSort;
import com.example.novel.mapper.BssNovelSortMapper;
import com.example.novel.service.IBssNovelSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelSortServiceImpl
 * @Description: TODO   业务-小说分类 服务实现类
 * @date 2022-03-27
 */
@Service
public class BssNovelSortServiceImpl extends ServiceImpl<BssNovelSortMapper, BssNovelSort> implements IBssNovelSortService {

    @Autowired
    public BssNovelSortMapper bssNovelSortMapper;


    /**
     * 业务-小说分类查询列表
     *
     * @param bssNovelSort
     * @return
     */
    @Override
    public List<BssNovelSort> selectBssNovelSortList(BssNovelSort bssNovelSort) {
        List<BssNovelSort> list = bssNovelSortMapper.selectBssNovelSortList(bssNovelSort);
        return list;
    }

    /**
     * 业务-小说分类详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public BssNovelSort selectBssNovelSortById(Integer id) {
        BssNovelSort result = bssNovelSortMapper.selectBssNovelSortById(id);
        return result;
    }

    /**
     * 业务-小说分类详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssNovelSort
     */
    @Override
    public List<BssNovelSort> selectBssNovelSortByIds(Integer[] ids) {
        List<BssNovelSort> result = bssNovelSortMapper.selectBssNovelSortByIds(ids);
        return result;
    }

    /**
     * 业务-小说分类新增
     *
     * @param bssNovelSort
     * @return
     */
    @Override
    @Transactional
    public int insertBssNovelSort(BssNovelSort bssNovelSort) {
        bssNovelSort.setCreateAt(new Date());
        return bssNovelSortMapper.insertBssNovelSort(bssNovelSort);
    }

    /**
     * 业务-小说分类修改
     *
     * @param bssNovelSort
     * @return
     */
    @Override
    @Transactional
    public int updateBssNovelSort(BssNovelSort bssNovelSort) {
        bssNovelSort.setUpdateAt(new Date());
        return bssNovelSortMapper.updateBssNovelSort(bssNovelSort);
    }

    /**
     * 业务-小说分类删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteBssNovelSortById(Integer id) {
        return bssNovelSortMapper.deleteBssNovelSortById(id);
    }

    /**
     * 业务-小说分类删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteBssNovelSortByIds(Integer[] ids) {
        return bssNovelSortMapper.deleteBssNovelSortByIds(ids);
    }
}
