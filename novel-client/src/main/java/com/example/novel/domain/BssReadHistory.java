package com.example.novel.domain;

import com.example.novel.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author youwenkai
 * @ClassName: BssReadHistory
 * @Description: TODO   阅读历史 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("阅读历史")
public class BssReadHistory extends BaseEntity implements Serializable {

    private Integer id;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 小说id
     */
    @ApiModelProperty("小说id")
    private Integer novelInfoId;
    /**
     * 阅读进度
     */
    @ApiModelProperty("阅读进度")
    private String readProgress;
    /**
     * 浏览时间
     */
    @ApiModelProperty("浏览时间")
    private LocalDateTime browseTime;
    /**
     * 是否加入书架
     */
    @ApiModelProperty("是否加入书架")
    private String isBookShelf;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private String delFlag;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private Integer[] ids;
}
