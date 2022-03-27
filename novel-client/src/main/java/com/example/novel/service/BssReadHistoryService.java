package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssReadHistory;

import java.util.List;

/**
 *
 * @ClassName: BssReadHistoryService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface BssReadHistoryService extends IService<BssReadHistory> {

    List<BssReadHistory> selectBssReadHistoryList(BssReadHistory bssReadHistory);

}