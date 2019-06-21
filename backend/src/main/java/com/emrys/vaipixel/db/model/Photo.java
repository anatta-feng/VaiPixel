package com.emrys.vaipixel.db.model;


import java.sql.Timestamp;
import java.util.List;

public class Photo {

    //主键
    private long id;

    //""
    private String title;

    //作品描述
    private String description;

    //创建时间
    private Timestamp createTime;

    //更新时间
    private Timestamp updateTime;

    //图片宽度/视频宽度
    private long width;

    //图片高度/视频高度
    private long height;

    private String rowUrl;

    private String fullUrl;

    private String regularUrl;

    private String smallUrl;

    private String thumbUrl;

    private CameraParameter cameraParameter;

    //分类id
    private long categoryId;

    private Category category;

    private List<Tag> tags;

    //作者id
    private long authorId;

    private User user;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateTime() {
        return this.createTime.getTime();
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return this.updateTime.getTime();
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public long getWidth() {
        return this.width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return this.height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public String getRowUrl() {
        return this.rowUrl;
    }

    public void setRowUrl(String rowUrl) {
        this.rowUrl = rowUrl;
    }

    public String getFullUrl() {
        return this.fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getRegularUrl() {
        return this.regularUrl;
    }

    public void setRegularUrl(String regularUrl) {
        this.regularUrl = regularUrl;
    }

    public String getSmallUrl() {
        return this.smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public CameraParameter getCameraParameter() {
        return cameraParameter;
    }

    public void setCameraParameter(CameraParameter cameraParameter) {
        this.cameraParameter = cameraParameter;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", width=" + width +
                ", height=" + height +
                ", rowUrl='" + rowUrl + '\'' +
                ", fullUrl='" + fullUrl + '\'' +
                ", regularUrl='" + regularUrl + '\'' +
                ", smallUrl='" + smallUrl + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", categoryId=" + categoryId +
                ", category=" + category +
                ", tags=" + tags +
                ", authorId=" + authorId +
                ", user=" + user +
                '}';
    }
}