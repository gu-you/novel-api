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
 * @ClassName: SysUser
 * @Description: TODO   系统-用户表 服务类
 * @date 2022-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统-用户表")
public class SysUser extends BaseEntity implements Serializable {

    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String passWord;
    /**
     * Y为男N为女
     */
    @ApiModelProperty("Y为男N为女")
    private String six;
    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String address;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String eMail;
    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String filePath;
    /**
     * Y为正常，N为异常(暂定)
     */
    @ApiModelProperty("Y为正常，N为异常(暂定)")
    private String status;
    /**
     * Y为vip
     */
    @ApiModelProperty("Y为vip")
    private String isVip;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createAt;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createBy;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date updateAt;
    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updateBy;


    private Integer[] ids;
}
