package com.example.novel.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
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
 * @ClassName: SysRole
 * @Description: TODO 角色表
 * @date 2022-03-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "role_id", type = IdType.ID_WORKER)
    private Integer roleId;
    /**
     * 权限标识
     */
    @TableField("role_key")
    private String roleKey;


    /**
     * 权限名称
     */
    @TableField("role_name")
    private String roleName;


    /**
     * 删除标识
     */
    @TableField("del_flag")
    @TableLogic
    private String delFlag;


    /**
     * 版本，解决并发
     */
    @TableField("version")
    private String version;


    @TableField(value = "create_at", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;


    @TableField("create_by")
    private String createBy;


    @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateAt;


    @TableField("update_by")
    private String updateBy;
}
