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
 * @ClassName: SysRole
 * @Description: TODO   系统-权限 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统-权限")
public class SysRole extends BaseEntity implements Serializable {

    private Integer roleId;
    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String roleKey;
    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String roleName;
    /**
     * 删除标识
     */
    @ApiModelProperty("删除标识")
    private String delFlag;
    /**
     * 版本，解决并发
     */
    @ApiModelProperty("版本，解决并发")
    private String version;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    private Integer[] ids;
}
