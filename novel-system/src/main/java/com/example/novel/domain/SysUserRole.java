package com.example.novel.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author You
 * @ClassName: SysUserRole
 * @Description: TODO 角色用户关联表
 * @date 2022-03-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@TableName("sys_user_role")
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableField("role_id")
    private Integer roleId;


    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;
}
