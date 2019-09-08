package com.emrys.vaipixel.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static com.emrys.vaipixel.db.enums.WorkTypeEnum.photo;

public class Photo extends Work {
    @JsonIgnore
    private long photoId;
    private CameraParameter cameraParameter;
    private String color;

    public Photo() {
        setType(photo);
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public CameraParameter getCameraParameter() {
        return cameraParameter;
    }

    public void setCameraParameter(CameraParameter cameraParameter) {
        this.cameraParameter = cameraParameter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", cameraParameter=" + cameraParameter +
                ", color='" + color + '\'' +
                '}';
    }
}
