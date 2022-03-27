package com.example.novel.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.novel.domain.BssNovelInfo;
import com.example.novel.mapper.BssNovelInfoMapper;
import com.example.novel.service.BssNovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: BssNovelInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class BssNovelInfoServiceImpl extends ServiceImpl<BssNovelInfoMapper, BssNovelInfo> implements BssNovelInfoService {

    @Autowired
    private BssNovelInfoMapper bssNovelInfoMapper;
    @Override
    public List<BssNovelInfo> selectBssNovelInfoList(BssNovelInfo bssNovelInfo) {
        return bssNovelInfoMapper.selectBssNovelInfoList(bssNovelInfo);
    }
}