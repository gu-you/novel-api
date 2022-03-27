package com.example.novel.domain;

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
// @TableName("sys_role")
public class SysRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer roleId;
    /**
     * 权限标识
     */
    private String roleKey;


    /**
     * 权限名称
     */
    private String roleName;


    /**
     * 删除标识
     */
    private String delFlag;


    /**
     * 版本，解决并发
     */
    private String version;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;


    private String createBy;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateAt;


    private String updateBy;
}
