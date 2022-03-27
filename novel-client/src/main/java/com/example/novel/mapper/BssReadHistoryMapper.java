package com.example.novel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.novel.domain.BssReadHistory;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Mapper
public interface BssReadHistoryMapper extends BaseMapper<BssReadHistory> {


    List<BssReadHistory> selectBssReadHistoryList(BssReadHistory bssReadHistory);
}