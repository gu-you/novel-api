package com.example.novel.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.novel.domain.BssNovelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Mapper
public interface BssNovelInfoMapper extends BaseMapper<BssNovelInfo> {

    List<BssNovelInfo> selectBssNovelInfoList(BssNovelInfo bssNovelInfo);
}