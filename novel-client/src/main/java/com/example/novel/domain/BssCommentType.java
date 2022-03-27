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
 * @ClassName: BssCommentType
 * @Description: TODO   业务-评论分类 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("业务-评论分类")
public class BssCommentType extends BaseEntity implements Serializable {

    private Integer id;
    /**
     * 评论分类
     */
    @ApiModelProperty("评论分类")
    private String commentType;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private String delFlag;

    private Integer[] ids;
}
