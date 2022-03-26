package com.example.novel.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author You
 * @ClassName: BssCommentType
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("bss_comment_type")
public class BssCommentType implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;


    /**
     * 评论分类
     */
    @TableField("comment_type")
    private String commentType;


    @TableField(value = "create_at", fill = FieldFill.INSERT)
    private Date createAt;


    @TableField("create_by")
    private String createBy;


    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    private Date updateAt;


    @TableField("update_by")
    private String updateBy;


    @TableField("del_flag")
    @TableLogic
    private String delFlag;
}
