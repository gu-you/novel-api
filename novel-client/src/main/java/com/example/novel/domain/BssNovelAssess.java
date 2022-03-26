package com.example.novel.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.example.novel.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author You
 * @ClassName: BssNovelAssess
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("bss_novel_assess")
public class BssNovelAssess extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;


    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;


    /**
     * 小说id
     */
    @TableField("novel_info_id")
    private Integer novelInfoId;


    /**
     * 评论内容
     */
    @TableField("assess_content")
    private String assessContent;


    /**
     * 父级id
     */
    @TableField("superior_id")
    private Integer superiorId;


    /**
     * 点赞
     */
    @TableField("fabulous_num")
    private Long fabulousNum;


    /**
     * 评论类型
     */
    @TableField("comment_id")
    private Integer commentId;


    /**
     * 评分
     */
    @TableField("score")
    private BigDecimal score;


    /**
     * 是否删除
     */
    @TableField("de_flag")
    private String deFlag;


    @TableField(value = "create_at", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;


    @TableField("create_by")
    private String createBy;
}
