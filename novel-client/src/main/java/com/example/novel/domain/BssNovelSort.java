package com.example.novel.domain;

import com.example.novel.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author You
 * @ClassName: BssNovelSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @TableName("bss_novel_sort")
public class BssNovelSort extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    // @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;


    /**
     * 分类名称
     */
    // @TableField("sort_name")
    private String sortName;


    /**
     * 版本
     */
    // @TableField("version")
    private String version;


    /**
     * 删除
     */
    // @TableField("del_flag")
    // @TableLogic
    private String delFlag;


    // @TableField(value = "create_at", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;


    // @TableField("create_by")
    private String createBy;


    // @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateAt;


    // @TableField("update_by")
    private String updateBy;
}
