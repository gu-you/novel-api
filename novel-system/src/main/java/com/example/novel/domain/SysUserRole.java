package com.example.novel.domain;

import com.example.novel.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author youwenkai
 * @ClassName: SysUserRole
 * @Description: TODO   系统-用户权限关联表 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统-用户权限关联表")
public class SysUserRole extends BaseEntity implements Serializable {

    /**
     * 权限id
     */
    @ApiModelProperty("权限id")
    private Integer roleId;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;



    private Integer[] ids;
}
