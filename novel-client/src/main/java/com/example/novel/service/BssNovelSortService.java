package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssNovelSort;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @ClassName: BssNovelSortService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface BssNovelSortService extends IService<BssNovelSort> {

    List<BssNovelSort> selectBssNovelSortList(BssNovelSort bssNovelSort);
}