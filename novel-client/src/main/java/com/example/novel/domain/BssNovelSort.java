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

;

/**
 * @author youwenkai
 * @ClassName: BssNovelSort
 * @Description: TODO   业务-小说分类 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("业务-小说分类")
public class BssNovelSort extends BaseEntity implements Serializable {

    private Integer id;
    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String sortName;
    /**
     * 版本
     */
    @ApiModelProperty("版本")
    private String version;
    /**
     * 删除
     */
    @ApiModelProperty("删除")
    private String delFlag;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private Integer[] ids;
}
