package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssNovelSort;
import com.example.novel.mapper.BssNovelSortMapper;
import com.example.novel.service.BssNovelSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: BssNovelSortServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class BssNovelSortServiceImpl extends ServiceImpl<BssNovelSortMapper, BssNovelSort> implements BssNovelSortService {

    @Autowired
    private BssNovelSortMapper bssNovelSortMapper;
    @Override
    public List<BssNovelSort> selectBssNovelSortList(BssNovelSort bssNovelSort) {
        return bssNovelSortMapper.selectBssNovelSortList(bssNovelSort);
    }
}