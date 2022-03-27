package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssCommentType;
import com.example.novel.mapper.BssCommentTypeMapper;
import com.example.novel.service.BssCommentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @ClassName: BssCommentTypeServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@Service
public class BssCommentTypeServiceImpl extends ServiceImpl<BssCommentTypeMapper, BssCommentType> implements BssCommentTypeService {

    @Autowired
    private BssCommentTypeMapper bssCommentTypeMapper;
    @Override
    public List<BssCommentType> selectBssCommentTypeList(BssCommentType bssCommentType) {
        return bssCommentTypeMapper.selectBssCommentTypeList(bssCommentType);
    }
}