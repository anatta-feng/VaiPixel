package com.emrys.vaipixel.db.model;


import com.emrys.vaipixel.db.enums.WorkTypeEnum;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Work implements Serializable {
    private long workId;
    private String title;
    private String description;
    private Timestamp createdTime;
    private Timestamp updatedTime;
    private int width;
    private int height;
    private WorkTypeEnum type;
    private Image image;
    private Category category;
    private List<Tag> tags;
    private User author;
    private int likeCount;
    private int pageView;
    private int userView;

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedTime() {
        return createdTime.getTime();
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public long getUpdatedTime() {
        return updatedTime.getTime();
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public WorkTypeEnum getType() {
        return type;
    }

    public void setType(WorkTypeEnum type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getPageView() {
        return pageView;
    }

    public void setPageView(int pageView) {
        this.pageView = pageView;
    }

    public int getUserView() {
        return userView;
    }

    public void setUserView(int userView) {
        this.userView = userView;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", width=" + width +
                ", height=" + height +
                ", type=" + type +
                ", image=" + image +
                ", category=" + category +
                ", tags=" + tags +
                ", author=" + author +
                '}';
    }
}
