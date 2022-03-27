package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssNovelAssess;
import com.example.novel.mapper.BssNovelAssessMapper;
import com.example.novel.service.IBssNovelAssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssNovelAssessServiceImpl
 * @Description: TODO   业务-评论 服务实现类
 * @date 2022-03-27
 */
@Service
public class BssNovelAssessServiceImpl extends ServiceImpl<BssNovelAssessMapper, BssNovelAssess> implements IBssNovelAssessService {

    @Autowired
    public BssNovelAssessMapper bssNovelAssessMapper;


    /**
     * 业务-评论查询列表
     *
     * @param bssNovelAssess
     * @return
     */
    @Override
    public List<BssNovelAssess> selectBssNovelAssessList(BssNovelAssess bssNovelAssess) {
        List<BssNovelAssess> list = bssNovelAssessMapper.selectBssNovelAssessList(bssNovelAssess);
        return list;
    }

    /**
     * 业务-评论详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public BssNovelAssess selectBssNovelAssessById(Integer id) {
        BssNovelAssess result = bssNovelAssessMapper.selectBssNovelAssessById(id);
        return result;
    }

    /**
     * 业务-评论详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssNovelAssess
     */
    @Override
    public List<BssNovelAssess> selectBssNovelAssessByIds(Integer[] ids) {
        List<BssNovelAssess> result = bssNovelAssessMapper.selectBssNovelAssessByIds(ids);
        return result;
    }

    /**
     * 业务-评论新增
     *
     * @param bssNovelAssess
     * @return
     */
    @Override
    @Transactional
    public int insertBssNovelAssess(BssNovelAssess bssNovelAssess) {
        bssNovelAssess.setCreateAt(new Date());
        return bssNovelAssessMapper.insertBssNovelAssess(bssNovelAssess);
    }

    /**
     * 业务-评论修改
     *
     * @param bssNovelAssess
     * @return
     */
    @Override
    @Transactional
    public int updateBssNovelAssess(BssNovelAssess bssNovelAssess) {
        return bssNovelAssessMapper.updateBssNovelAssess(bssNovelAssess);
    }

    /**
     * 业务-评论删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteBssNovelAssessById(Integer id) {
        return bssNovelAssessMapper.deleteBssNovelAssessById(id);
    }

    /**
     * 业务-评论删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteBssNovelAssessByIds(Integer[] ids) {
        return bssNovelAssessMapper.deleteBssNovelAssessByIds(ids);
    }
}
