package com.emrys.vaipixel.db1.model;


import com.emrys.vaipixel.db1.enums.WorkTypeEnum;

import java.io.Serializable;

public class Work implements Serializable {
    private long workId;
    private String workName;
    private String description;
    private long createdTime;
    private long updatedTime;
    private int width;
    private int height;
    private WorkTypeEnum workType;

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public WorkTypeEnum getWorkType() {
        return workType;
    }

    public void setWorkType(WorkTypeEnum workType) {
        this.workType = workType;
    }
}
