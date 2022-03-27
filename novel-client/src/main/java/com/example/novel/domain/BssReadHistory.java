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
 * @ClassName: BssReadHistory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// @TableName("bss_read_history")
public class BssReadHistory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    // @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;


    /**
     * 用户id
     */
    // @TableField("user_id")
    private Integer userId;


    /**
     * 小说id
     */
    // @TableField("novel_info_id")
    private Integer novelInfoId;


    /**
     * 阅读进度
     */
    // @TableField("read_progress")
    private String readProgress;


    /**
     * 浏览时间
     */
    // @TableField("browse_time")
    private Date browseTime;


    /**
     * 是否加入书架
     */
    // @TableField("is_book_shelf")
    private String isBookShelf;


    /**
     * 是否删除
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
