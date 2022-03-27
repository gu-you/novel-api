package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssNovelInfo;
import com.example.novel.mapper.BssNovelInfoMapper;
import com.example.novel.service.IBssNovelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelInfoServiceImpl
 * @Description: TODO   业务-小说详情 服务实现类
 * @date 2022-03-27
 */
@Service
public class BssNovelInfoServiceImpl extends ServiceImpl<BssNovelInfoMapper, BssNovelInfo> implements IBssNovelInfoService {

    @Autowired
    public BssNovelInfoMapper bssNovelInfoMapper;


    /**
     * 业务-小说详情查询列表
     *
     * @param bssNovelInfo
     * @return
     */
    @Override
    public List<BssNovelInfo> selectBssNovelInfoList(BssNovelInfo bssNovelInfo) {
        List<BssNovelInfo> list = bssNovelInfoMapper.selectBssNovelInfoList(bssNovelInfo);
        return list;
    }

    /**
     * 业务-小说详情详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public BssNovelInfo selectBssNovelInfoById(Integer id) {
        BssNovelInfo result = bssNovelInfoMapper.selectBssNovelInfoById(id);
        return result;
    }

    /**
     * 业务-小说详情详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssNovelInfo
     */
    @Override
    public List<BssNovelInfo> selectBssNovelInfoByIds(Integer[] ids) {
        List<BssNovelInfo> result = bssNovelInfoMapper.selectBssNovelInfoByIds(ids);
        return result;
    }

    /**
     * 业务-小说详情新增
     *
     * @param bssNovelInfo
     * @return
     */
    @Override
    @Transactional
    public int insertBssNovelInfo(BssNovelInfo bssNovelInfo) {
        bssNovelInfo.setCreateAt(new Date());
        return bssNovelInfoMapper.insertBssNovelInfo(bssNovelInfo);
    }

    /**
     * 业务-小说详情修改
     *
     * @param bssNovelInfo
     * @return
     */
    @Override
    @Transactional
    public int updateBssNovelInfo(BssNovelInfo bssNovelInfo) {
        bssNovelInfo.setUpdateAt(new Date());
        return bssNovelInfoMapper.updateBssNovelInfo(bssNovelInfo);
    }

    /**
     * 业务-小说详情删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteBssNovelInfoById(Integer id) {
        return bssNovelInfoMapper.deleteBssNovelInfoById(id);
    }

    /**
     * 业务-小说详情删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteBssNovelInfoByIds(Integer[] ids) {
        return bssNovelInfoMapper.deleteBssNovelInfoByIds(ids);
    }
}
