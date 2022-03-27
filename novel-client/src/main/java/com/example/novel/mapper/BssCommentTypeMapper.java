package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.BssCommentType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BssCommentTypeMapper extends BaseMapper<BssCommentType> {

    /**
     * 查询bssCommentType列表
     * @param bssCommentType
     * @return
     */
    List<BssCommentType> selectBssCommentTypeList(BssCommentType bssCommentType);
}