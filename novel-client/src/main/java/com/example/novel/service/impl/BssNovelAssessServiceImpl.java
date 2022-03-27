package com.example.novel.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.novel.domain.BssNovelAssess;
import com.example.novel.mapper.BssNovelAssessMapper;
import com.example.novel.service.BssNovelAssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: BssNovelAssessServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class BssNovelAssessServiceImpl extends ServiceImpl<BssNovelAssessMapper, BssNovelAssess> implements BssNovelAssessService {

    @Autowired
    private BssNovelAssessMapper bssNovelAssessMapper;
    @Override
    public List<BssNovelAssess> selectBssNovelAssessList(BssNovelAssess bssNovelAssess) {
        return bssNovelAssessMapper.selectBssNovelAssessList(bssNovelAssess);
    }
}