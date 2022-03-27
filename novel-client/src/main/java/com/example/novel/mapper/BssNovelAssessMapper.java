package com.example.novel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.novel.domain.BssNovelAssess;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BssNovelAssessMapper extends BaseMapper<BssNovelAssess> {

    List<BssNovelAssess> selectBssNovelAssessList(BssNovelAssess bssNovelAssess);
}