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
 * @ClassName: BssNovelSort
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@TableName("bss_novel_sort")
public class BssNovelSort extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 1L;

        
                                @TableId(value="id", type= IdType.ID_WORKER)
        @NotBlank(message = "主键不能为空", groups={EditGroup.class})
                                    private Integer id;

    
        /**
     * 分类名称
     */
            @TableField("sort_name")
                    private String sortName;

    
        /**
     * 版本
     */
            @TableField("version")
                    private String version;

    
        /**
     * 删除
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
                    
    public String getSortName() {
            return sortName;
            }

                public void setSortName(String sortName) {
                    this.sortName = sortName;
                    }
                    
    public String getVersion() {
            return version;
            }

                public void setVersion(String version) {
                    this.version = version;
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
        return "BssNovelSort{" +
                            "id=" + id +
                                    ", sortName=" + sortName +
                                    ", version=" + version +
                                    ", delFlag=" + delFlag +
                                    ", createAt=" + createAt +
                                    ", createBy=" + createBy +
                                    ", updateAt=" + updateAt +
                                    ", updateBy=" + updateBy +
                    "}";
        }
        }
