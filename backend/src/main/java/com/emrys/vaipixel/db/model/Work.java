package com.emrys.vaipixel.db.model;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;

public class Work {
    private long id;
    private long createdTime;
    private long updatedTime;
    private int width;
    private int height;
    private WorkTypeEnum type;

    private String title;
    private String description;

    private Image image;

    private int duration;

    private CameraParameter cameraParameter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public CameraParameter getCameraParameter() {
        return cameraParameter;
    }

    public void setCameraParameter(CameraParameter cameraParameter) {
        this.cameraParameter = cameraParameter;
    }
}
