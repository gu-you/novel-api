package com.example.novel.domain;

import com.glens.eap.platform.beanvalidator.EditGroup;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableId;
        import java.util.Date;
        import com.baomidou.mybatisplus.annotations.TableField;
        import com.baomidou.mybatisplus.enums.FieldFill;
        import com.baomidou.mybatisplus.annotations.TableName;
        import com.baomidou.mybatisplus.annotations.TableLogic;
        import com.example.novel.base.BaseEntity;
        import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @ClassName: BssNovelInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author You
 * @date 2022-03-26
 */
@TableName("bss_novel_info")
public class BssNovelInfo extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 1L;

    
            @TableField("id")
                    private Integer id;

    
        /**
     * 小说名称
     */
            @TableField("novel_name")
                    private String novelName;

    
        /**
     * 分类id
     */
            @TableField("sort_id")
                    private Integer sortId;

    
        /**
     * 是否删除
     */
            @TableField("del_flag")
                        @TableLogic
    private String delFlag;

    
        /**
     * 文件地址
     */
            @TableField("file_path")
                    private String filePath;

    
        /**
     * 封面地址
     */
            @TableField("file_cover_path")
                    private String fileCoverPath;

    
        /**
     * 简介
     */
            @TableField("synopsis")
                    private String synopsis;

    
        /**
     * 字数
     */
            @TableField("word_num")
                    private String wordNum;

    
        /**
     * 是否完结
     */
            @TableField("is_end")
                    private String isEnd;

    
        /**
     * 作者
     */
            @TableField("author")
                    private String author;

    
        /**
     * 主人公
     */
            @TableField("protagonist")
                    private String protagonist;

    
        /**
     * 最新目录
     */
            @TableField("catalogue")
                    private String catalogue;

    
        /**
     * 是否上架
     */
            @TableField("is_shelves")
                    private String isShelves;

    
                                @TableField(value = "create_at", fill = FieldFill.INSERT)
                            private Date createAt;

    
            @TableField("create_by")
                    private String createBy;

    
            @TableField("update_by")
                    private String updateBy;

    
                                @TableField(value = "update_at", fill = FieldFill.INSERT_UPDATE)
                            private Date updateAt;




                    
    public Integer getId() {
            return id;
            }

                public void setId(Integer id) {
                    this.id = id;
                    }
                    
    public String getNovelName() {
            return novelName;
            }

                public void setNovelName(String novelName) {
                    this.novelName = novelName;
                    }
                    
    public Integer getSortId() {
            return sortId;
            }

                public void setSortId(Integer sortId) {
                    this.sortId = sortId;
                    }
                    
    public String getDelFlag() {
            return delFlag;
            }

                public void setDelFlag(String delFlag) {
                    this.delFlag = delFlag;
                    }
                    
    public String getFilePath() {
            return filePath;
            }

                public void setFilePath(String filePath) {
                    this.filePath = filePath;
                    }
                    
    public String getFileCoverPath() {
            return fileCoverPath;
            }

                public void setFileCoverPath(String fileCoverPath) {
                    this.fileCoverPath = fileCoverPath;
                    }
                    
    public String getSynopsis() {
            return synopsis;
            }

                public void setSynopsis(String synopsis) {
                    this.synopsis = synopsis;
                    }
                    
    public String getWordNum() {
            return wordNum;
            }

                public void setWordNum(String wordNum) {
                    this.wordNum = wordNum;
                    }
                    
    public String getIsEnd() {
            return isEnd;
            }

                public void setIsEnd(String isEnd) {
                    this.isEnd = isEnd;
                    }
                    
    public String getAuthor() {
            return author;
            }

                public void setAuthor(String author) {
                    this.author = author;
                    }
                    
    public String getProtagonist() {
            return protagonist;
            }

                public void setProtagonist(String protagonist) {
                    this.protagonist = protagonist;
                    }
                    
    public String getCatalogue() {
            return catalogue;
            }

                public void setCatalogue(String catalogue) {
                    this.catalogue = catalogue;
                    }
                    
    public String getIsShelves() {
            return isShelves;
            }

                public void setIsShelves(String isShelves) {
                    this.isShelves = isShelves;
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
                    
    public String getUpdateBy() {
            return updateBy;
            }

                public void setUpdateBy(String updateBy) {
                    this.updateBy = updateBy;
                    }
                    
    public Date getUpdateAt() {
            return updateAt;
            }

                public void setUpdateAt(Date updateAt) {
                    this.updateAt = updateAt;
                    }
    

@Override
public String toString() {
        return "BssNovelInfo{" +
                            "id=" + id +
                                    ", novelName=" + novelName +
                                    ", sortId=" + sortId +
                                    ", delFlag=" + delFlag +
                                    ", filePath=" + filePath +
                                    ", fileCoverPath=" + fileCoverPath +
                                    ", synopsis=" + synopsis +
                                    ", wordNum=" + wordNum +
                                    ", isEnd=" + isEnd +
                                    ", author=" + author +
                                    ", protagonist=" + protagonist +
                                    ", catalogue=" + catalogue +
                                    ", isShelves=" + isShelves +
                                    ", createAt=" + createAt +
                                    ", createBy=" + createBy +
                                    ", updateBy=" + updateBy +
                                    ", updateAt=" + updateAt +
                    "}";
        }
        }
