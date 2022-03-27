package com.example.novel.domain;

import com.example.novel.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author You
 * @ClassName: SysUser
 * @Description: TODO 用户表
 * @date 2022-03-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel("用户实体类")
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty("用户序列id")
    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty("用户自增id")
    private Integer userId;


    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;


    /**
     * 密码
     */
    @ApiModelProperty("用户密码")
    private String passWord;


    /**
     * Y为男N为女
     */
    // @TableField("six")
    private String six;


    /**
     * 地址
     */
    // @TableField("address")
    private String address;


    /**
     * 手机号
     */
    // @TableField("phone")
    private String phone;


    /**
     * 邮箱
    //  */
    // @TableField("e_mail")
    private String eMail;


    /**
     * 头像地址
     */
    // @TableField("file_path")
    private String filePath;


    /**
     * Y为正常，N为异常(暂定)
     */
    // @TableField("status")
    private String status;


    /**
     * Y为vip
     */
    // @TableField("is_vip")
    private String isVip;


    /**
     * 创建时间
     */
    // @TableField(value = "create_at", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;


    /**
     * 创建人
     */
    // @TableField("create_by")
    private String createBy;


    /**
     * 修改时间
     */
    // @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateAt;


    /**
     * 修改人
     */
    // @TableField("update_by")
    private String updateBy;
}
