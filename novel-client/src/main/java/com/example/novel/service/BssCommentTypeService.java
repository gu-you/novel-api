package com.example.novel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.novel.domain.BssCommentType;

import java.util.List;

/**
 *
 * @ClassName: BssCommentTypeService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
public interface BssCommentTypeService extends IService<BssCommentType> {

    List<BssCommentType> selectBssCommentTypeList(BssCommentType bssCommentType);

}