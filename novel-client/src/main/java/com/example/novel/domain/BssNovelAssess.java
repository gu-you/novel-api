package com.example.novel.domain;

import com.example.novel.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author youwenkai
 * @ClassName: BssNovelAssess
 * @Description: TODO   业务-评论 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("业务-评论")
public class BssNovelAssess extends BaseEntity implements Serializable {

    private Integer id;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * 小说id
     */
    @ApiModelProperty("小说id")
    private Integer novelInfoId;
    /**
     * 评论内容
     */
    @ApiModelProperty("评论内容")
    private String assessContent;
    /**
     * 父级id
     */
    @ApiModelProperty("父级id")
    private Integer superiorId;
    /**
     * 点赞
     */
    @ApiModelProperty("点赞")
    private Long fabulousNum;
    /**
     * 评论类型
     */
    @ApiModelProperty("评论类型")
    private Integer commentId;
    /**
     * 评分
     */
    @ApiModelProperty("评分")
    private BigDecimal score;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private String deFlag;

    private Date createAt;

    private String createBy;

    private Integer[] ids;
}
