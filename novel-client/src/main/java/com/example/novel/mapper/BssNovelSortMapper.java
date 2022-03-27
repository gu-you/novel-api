package com.example.novel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.novel.domain.BssNovelSort;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Mapper
public interface BssNovelSortMapper extends BaseMapper<BssNovelSort> {

    List<BssNovelSort> selectBssNovelSortList(BssNovelSort bssNovelSort);
}