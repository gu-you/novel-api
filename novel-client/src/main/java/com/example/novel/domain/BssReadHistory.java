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
 * @ClassName: BssReadHistory
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@TableName("bss_read_history")
public class BssReadHistory extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 1L;

        
                                @TableId(value="id", type= IdType.ID_WORKER)
        @NotBlank(message = "主键不能为空", groups={EditGroup.class})
                                    private Integer id;

    
        /**
     * 用户id
     */
            @TableField("user_id")
                    private Integer userId;

    
        /**
     * 小说id
     */
            @TableField("novel_info_id")
                    private Integer novelInfoId;

    
        /**
     * 阅读进度
     */
            @TableField("read_progress")
                    private String readProgress;

    
        /**
     * 浏览时间
     */
            @TableField("browse_time")
                    private Date browseTime;

    
        /**
     * 是否加入书架
     */
            @TableField("is_book_shelf")
                    private String isBookShelf;

    
        /**
     * 是否删除
     */
            @TableField("del_flag")
                        @TableLogic
    private String delFlag;

    
                                @TableField(value = "create_at", fill = FieldFill.INSERT)
                            private Date createAt;

    
            @TableField("create_by")
                    private String createBy;

    
                                @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
                            private Date updateAt;

    
            @TableField("update_by")
                    private String updateBy;




                    
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
                    
    public String getReadProgress() {
            return readProgress;
            }

                public void setReadProgress(String readProgress) {
                    this.readProgress = readProgress;
                    }
                    
    public Date getBrowseTime() {
            return browseTime;
            }

                public void setBrowseTime(Date browseTime) {
                    this.browseTime = browseTime;
                    }
                    
    public String getIsBookShelf() {
            return isBookShelf;
            }

                public void setIsBookShelf(String isBookShelf) {
                    this.isBookShelf = isBookShelf;
                    }
                    
    public String getDelFlag() {
            return delFlag;
            }

                public void setDelFlag(String delFlag) {
                    this.delFlag = delFlag;
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
    

@Override
public String toString() {
        return "BssReadHistory{" +
                            "id=" + id +
                                    ", userId=" + userId +
                                    ", novelInfoId=" + novelInfoId +
                                    ", readProgress=" + readProgress +
                                    ", browseTime=" + browseTime +
                                    ", isBookShelf=" + isBookShelf +
                                    ", delFlag=" + delFlag +
                                    ", createAt=" + createAt +
                                    ", createBy=" + createBy +
                                    ", updateAt=" + updateAt +
                                    ", updateBy=" + updateBy +
                    "}";
        }
        }
