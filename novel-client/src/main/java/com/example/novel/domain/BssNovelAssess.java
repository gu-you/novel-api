package com.example.novel.domain;

import com.glens.eap.platform.beanvalidator.EditGroup;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableId;
        import com.baomidou.mybatisplus.enums.IdType;
        import java.math.BigDecimal;
        import java.util.Date;
        import com.baomidou.mybatisplus.annotations.TableId;
        import com.baomidou.mybatisplus.annotations.TableField;
        import com.baomidou.mybatisplus.enums.FieldFill;
        import com.baomidou.mybatisplus.annotations.TableName;
        import com.example.novel.base.BaseEntity;
        import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @ClassName: BssNovelAssess
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@TableName("bss_novel_assess")
public class BssNovelAssess extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 1L;

        
                                @TableId(value="id", type= IdType.ID_WORKER)
        @NotBlank(message = "主键不能为空", groups={EditGroup.class})
                                    private Integer id;

    
        /**
     * 用户ID
     */
            @TableField("user_id")
                    private Integer userId;

    
        /**
     * 小说id
     */
            @TableField("novel_info_id")
                    private Integer novelInfoId;

    
        /**
     * 评论内容
     */
            @TableField("assess_content")
                    private String assessContent;

    
        /**
     * 父级id
     */
            @TableField("superior_id")
                    private Integer superiorId;

    
        /**
     * 点赞
     */
            @TableField("fabulous_num")
                    private Long fabulousNum;

    
        /**
     * 评论类型
     */
            @TableField("comment_id")
                    private Integer commentId;

    
        /**
     * 评分
     */
            @TableField("score")
                    private BigDecimal score;

    
        /**
     * 是否删除
     */
            @TableField("de_flag")
                    private String deFlag;

    
                                @TableField(value = "create_at", fill = FieldFill.INSERT)
                            private Date createAt;

    
            @TableField("create_by")
                    private String createBy;




                    
    public Integer getId() {
            return id;
            }

                public void setId(Integer id) {
                    this.id = id;
                    }
                    
    public Integer getUserId() {
            return userId;
            }

                public void setUserId(Integer userId) {
                    this.userId = userId;
                    }
                    
    public Integer getNovelInfoId() {
            return novelInfoId;
            }

                public void setNovelInfoId(Integer novelInfoId) {
                    this.novelInfoId = novelInfoId;
                    }
                    
    public String getAssessContent() {
            return assessContent;
            }

                public void setAssessContent(String assessContent) {
                    this.assessContent = assessContent;
                    }
                    
    public Integer getSuperiorId() {
            return superiorId;
            }

                public void setSuperiorId(Integer superiorId) {
                    this.superiorId = superiorId;
                    }
                    
    public Long getFabulousNum() {
            return fabulousNum;
            }

                public void setFabulousNum(Long fabulousNum) {
                    this.fabulousNum = fabulousNum;
                    }
                    
    public Integer getCommentId() {
            return commentId;
            }

                public void setCommentId(Integer commentId) {
                    this.commentId = commentId;
                    }
                    
    public BigDecimal getScore() {
            return score;
            }

                public void setScore(BigDecimal score) {
                    this.score = score;
                    }
                    
    public String getDeFlag() {
            return deFlag;
            }

                public void setDeFlag(String deFlag) {
                    this.deFlag = deFlag;
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
    

@Override
public String toString() {
        return "BssNovelAssess{" +
                            "id=" + id +
                                    ", userId=" + userId +
                                    ", novelInfoId=" + novelInfoId +
                                    ", assessContent=" + assessContent +
                                    ", superiorId=" + superiorId +
                                    ", fabulousNum=" + fabulousNum +
                                    ", commentId=" + commentId +
                                    ", score=" + score +
                                    ", deFlag=" + deFlag +
                                    ", createAt=" + createAt +
                                    ", createBy=" + createBy +
                    "}";
        }
        }
