package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssReadHistory;
import com.example.novel.mapper.BssReadHistoryMapper;
import com.example.novel.service.BssReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: BssReadHistoryServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class BssReadHistoryServiceImpl extends ServiceImpl<BssReadHistoryMapper, BssReadHistory> implements BssReadHistoryService {

    @Autowired
    private BssReadHistoryMapper bssReadHistoryMapper;

    @Override
    public List<BssReadHistory> selectBssReadHistoryList(BssReadHistory bssReadHistory) {
        return bssReadHistoryMapper.selectBssReadHistoryList(bssReadHistory);
    }
}