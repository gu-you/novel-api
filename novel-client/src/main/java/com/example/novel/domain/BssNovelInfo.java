package com.example.novel.domain;

import com.example.novel.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author youwenkai
 * @ClassName: BssNovelInfo
 * @Description: TODO   业务-小说详情 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("业务-小说详情")
public class BssNovelInfo extends BaseEntity implements Serializable {

    private Integer id;
    /**
     * 小说名称
     */
    @ApiModelProperty("小说名称")
    private String novelName;
    /**
     * 分类id
     */
    @ApiModelProperty("分类id")
    private Integer sortId;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private String delFlag;
    /**
     * 文件地址
     */
    @ApiModelProperty("文件地址")
    private String filePath;
    /**
     * 封面地址
     */
    @ApiModelProperty("封面地址")
    private String fileCoverPath;
    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String synopsis;
    /**
     * 字数
     */
    @ApiModelProperty("字数")
    private String wordNum;
    /**
     * 是否完结
     */
    @ApiModelProperty("是否完结")
    private String isEnd;
    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String author;
    /**
     * 主人公
     */
    @ApiModelProperty("主人公")
    private String protagonist;
    /**
     * 最新目录
     */
    @ApiModelProperty("最新目录")
    private String catalogue;
    /**
     * 是否上架
     */
    @ApiModelProperty("是否上架")
    private String isShelves;

    private Date createAt;

    private String createBy;

    private String updateBy;

    private Date updateAt;

    private Integer[] ids;
}
