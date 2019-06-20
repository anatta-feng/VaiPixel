package com.emrys.vaipixel.db.model;


import java.sql.Date;
import java.util.List;

public class Photo {

    //主键
    private long id;

    //""
    private String title;

    //作品描述
    private String description;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //图片宽度/视频宽度
    private long width;

    //图片高度/视频高度
    private long height;

    private String rowUrl;

    private String fullUrl;

    private String regularUrl;

    private String smallUrl;

    private String thumbUrl;

    //相机
    private String camera;

    //镜头
    private String lens;

    //焦距
    private long focalLength;

    //光圈
    private long aperture;

    //iso
    private long iso;

    //快门时间
    private String shutter;

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

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    public String getCamera() {
        return this.camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return this.lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public long getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(long focalLength) {
        this.focalLength = focalLength;
    }

    public long getAperture() {
        return this.aperture;
    }

    public void setAperture(long aperture) {
        this.aperture = aperture;
    }

    public long getIso() {
        return this.iso;
    }

    public void setIso(long iso) {
        this.iso = iso;
    }

    public String getShutter() {
        return this.shutter;
    }

    public void setShutter(String shutter) {
        this.shutter = shutter;
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
}