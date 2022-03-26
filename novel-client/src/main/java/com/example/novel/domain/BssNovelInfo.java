package com.example.novel.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
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
 * @ClassName: BssNovelInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("bss_novel_info")
public class BssNovelInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableField("id")
    private Integer id;


    /**
     * 小说名称
     */
    @TableField("novel_name")
    private String novelName;


    /**
     * 分类id
     */
    @TableField("sort_id")
    private Integer sortId;


    /**
     * 是否删除
     */
    @TableField("del_flag")
    @TableLogic
    private String delFlag;


    /**
     * 文件地址
     */
    @TableField("file_path")
    private String filePath;


    /**
     * 封面地址
     */
    @TableField("file_cover_path")
    private String fileCoverPath;


    /**
     * 简介
     */
    @TableField("synopsis")
    private String synopsis;


    /**
     * 字数
     */
    @TableField("word_num")
    private String wordNum;


    /**
     * 是否完结
     */
    @TableField("is_end")
    private String isEnd;


    /**
     * 作者
     */
    @TableField("author")
    private String author;


    /**
     * 主人公
     */
    @TableField("protagonist")
    private String protagonist;


    /**
     * 最新目录
     */
    @TableField("catalogue")
    private String catalogue;


    /**
     * 是否上架
     */
    @TableField("is_shelves")
    private String isShelves;


    @TableField(value = "create_at", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;


    @TableField("create_by")
    private String createBy;


    @TableField("update_by")
    private String updateBy;


    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateAt;

}
