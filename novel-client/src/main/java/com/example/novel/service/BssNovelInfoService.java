package com.example.novel.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.novel.domain.BssNovelInfo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @ClassName: BssNovelInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface BssNovelInfoService extends IService<BssNovelInfo> {

    List<BssNovelInfo> selectBssNovelInfoList(BssNovelInfo bssNovelInfo);
}