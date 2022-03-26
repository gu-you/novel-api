package com.example.novel.domain;

import com.glens.eap.platform.beanvalidator.EditGroup;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableId;
        import com.baomidou.mybatisplus.enums.IdType;
        import java.util.Date;
        import com.baomidou.mybatisplus.annotations.TableId;
        import com.baomidou.mybatisplus.annotations.TableField;
        import com.baomidou.mybatisplus.enums.FieldFill;
        import com.baomidou.mybatisplus.annotations.TableName;
        import com.baomidou.mybatisplus.annotations.TableLogic;
        import com.example.novel.base.BaseEntity;
        import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @ClassName: BssCommentType
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@TableName("bss_comment_type")
public class BssCommentType extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 1L;

        
                                @TableId(value="id", type= IdType.ID_WORKER)
        @NotBlank(message = "主键不能为空", groups={EditGroup.class})
                                    private Integer id;

    
        /**
     * 评论分类
     */
            @TableField("comment_type")
                    private String commentType;

    
                                @TableField(value = "create_at", fill = FieldFill.INSERT)
                            private Date createAt;

    
            @TableField("create_by")
                    private String createBy;

    
                                @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
                            private Date updateAt;

    
            @TableField("update_by")
                    private String updateBy;

    
            @TableField("del_flag")
                        @TableLogic
    private String delFlag;




                    
    public Integer getId() {
            return id;
            }

                public void setId(Integer id) {
                    this.id = id;
                    }
                    
    public String getCommentType() {
            return commentType;
            }

                public void setCommentType(String commentType) {
                    this.commentType = commentType;
                    }
                    
    public Date getCreateAt() {
            return createAt;
            }

                public void setCreateAt(Date createAt) {
                    this.createAt = createAt;
                    }
                    
    public String getCreateBy() {
            return createBy;
            }

                public void setCreateBy(String createBy) {
                    this.createBy = createBy;
                    }
                    
    public Date getUpdateAt() {
            return updateAt;
            }

                public void setUpdateAt(Date updateAt) {
                    this.updateAt = updateAt;
                    }
                    
    public String getUpdateBy() {
            return updateBy;
            }

                public void setUpdateBy(String updateBy) {
                    this.updateBy = updateBy;
                    }
                    
    public String getDelFlag() {
            return delFlag;
            }

                public void setDelFlag(String delFlag) {
                    this.delFlag = delFlag;
                    }
    

@Override
public String toString() {
        return "BssCommentType{" +
                            "id=" + id +
                                    ", commentType=" + commentType +
                                    ", createAt=" + createAt +
                                    ", createBy=" + createBy +
                                    ", updateAt=" + updateAt +
                                    ", updateBy=" + updateBy +
                                    ", delFlag=" + delFlag +
                    "}";
        }
        }
