package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssReadHistory;
import com.example.novel.mapper.BssReadHistoryMapper;
import com.example.novel.service.IBssReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *
 * @ClassName: BssReadHistoryServiceImpl
 * @Description: TODO   阅读历史 服务实现类
 * @author youwenkai
 * @date 2022-03-27
 */
@Service
public class BssReadHistoryServiceImpl extends ServiceImpl<BssReadHistoryMapper, BssReadHistory> implements IBssReadHistoryService {

        @Autowired
        public BssReadHistoryMapper bssReadHistoryMapper;


        /**
         * 阅读历史查询列表
         * @param bssReadHistory
         * @return
         */
        @Override
        public List<BssReadHistory> selectBssReadHistoryList(BssReadHistory bssReadHistory) {
            List<BssReadHistory> list = bssReadHistoryMapper.selectBssReadHistoryList(bssReadHistory);
            return list;
        }

        /**
         * 阅读历史详情(单个条目)
         * @param id 主键
         * @return
         */
        @Override
        public BssReadHistory selectBssReadHistoryById(Integer id) {
            BssReadHistory result = bssReadHistoryMapper.selectBssReadHistoryById(id);
            return result;
        }

        /**
         * 阅读历史详情(多个条目)
         * @param ids 主键数组
         * @return BssReadHistory
         */
        @Override
        public List<BssReadHistory> selectBssReadHistoryByIds(Integer[] ids) {
            List<BssReadHistory> result = bssReadHistoryMapper.selectBssReadHistoryByIds(ids);
            return result;
        }

        /**
         * 阅读历史新增
         * @param bssReadHistory
         * @return
         */
        @Override
        @Transactional
        public int insertBssReadHistory(BssReadHistory bssReadHistory){
            bssReadHistory.setCreateAt(new Date());
            return bssReadHistoryMapper.insertBssReadHistory(bssReadHistory);
        }

        /**
         * 阅读历史修改
         * @param bssReadHistory
         * @return
         */
        @Override
        @Transactional
        public int updateBssReadHistory(BssReadHistory bssReadHistory) {
            bssReadHistory.setUpdateAt(new Date());
            return bssReadHistoryMapper.updateBssReadHistory(bssReadHistory);
        }

        /**
         * 阅读历史删除(单个条目)
         * @param id 主键
         * @return
         */
        @Override
        public int deleteBssReadHistoryById(Integer id) {
            return bssReadHistoryMapper.deleteBssReadHistoryById(id);
        }

        /**
         * 阅读历史删除(多个条目)
         * @param ids 主键数组
         * @return
         */
        @Override
        public int deleteBssReadHistoryByIds(Integer[] ids){
            return bssReadHistoryMapper.deleteBssReadHistoryByIds(ids);
        }
        }
