package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssNovelAssess;

import java.util.List;

/**
 *
 * @ClassName: BssNovelAssessService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface BssNovelAssessService extends IService<BssNovelAssess> {

    List<BssNovelAssess> selectBssNovelAssessList(BssNovelAssess bssNovelAssess);

}