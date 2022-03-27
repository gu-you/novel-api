package com.example.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.novel.domain.BssCommentType;
import com.example.novel.mapper.BssCommentTypeMapper;
import com.example.novel.service.IBssCommentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author youwenkai
 * @ClassName: BssCommentTypeServiceImpl
 * @Description: TODO   业务-评论分类 服务实现类
 * @date 2022-03-27
 */
@Service
public class BssCommentTypeServiceImpl extends ServiceImpl<BssCommentTypeMapper, BssCommentType> implements IBssCommentTypeService {

    @Autowired
    public BssCommentTypeMapper bssCommentTypeMapper;


    /**
     * 业务-评论分类查询列表
     *
     * @param bssCommentType
     * @return
     */
    @Override
    public List<BssCommentType> selectBssCommentTypeList(BssCommentType bssCommentType) {
        List<BssCommentType> list = bssCommentTypeMapper.selectBssCommentTypeList(bssCommentType);
        return list;
    }

    /**
     * 业务-评论分类详情(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public BssCommentType selectBssCommentTypeById(Integer id) {
        BssCommentType result = bssCommentTypeMapper.selectBssCommentTypeById(id);
        return result;
    }

    /**
     * 业务-评论分类详情(多个条目)
     *
     * @param ids 主键数组
     * @return BssCommentType
     */
    @Override
    public List<BssCommentType> selectBssCommentTypeByIds(Integer[] ids) {
        List<BssCommentType> result = bssCommentTypeMapper.selectBssCommentTypeByIds(ids);
        return result;
    }

    /**
     * 业务-评论分类新增
     *
     * @param bssCommentType
     * @return
     */
    @Override
    @Transactional
    public int insertBssCommentType(BssCommentType bssCommentType) {
        bssCommentType.setCreateAt(new Date());
        return bssCommentTypeMapper.insertBssCommentType(bssCommentType);
    }

    /**
     * 业务-评论分类修改
     *
     * @param bssCommentType
     * @return
     */
    @Override
    @Transactional
    public int updateBssCommentType(BssCommentType bssCommentType) {
        bssCommentType.setUpdateAt(new Date());
        return bssCommentTypeMapper.updateBssCommentType(bssCommentType);
    }

    /**
     * 业务-评论分类删除(单个条目)
     *
     * @param id 主键
     * @return
     */
    @Override
    public int deleteBssCommentTypeById(Integer id) {
        return bssCommentTypeMapper.deleteBssCommentTypeById(id);
    }

    /**
     * 业务-评论分类删除(多个条目)
     *
     * @param ids 主键数组
     * @return
     */
    @Override
    public int deleteBssCommentTypeByIds(Integer[] ids) {
        return bssCommentTypeMapper.deleteBssCommentTypeByIds(ids);
    }
}
