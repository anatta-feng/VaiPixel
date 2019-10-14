package com.emrys.vaipixel.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import static com.emrys.vaipixel.db.enums.WorkTypeEnum.photo;

@Data
public class Photo extends Work {
    @JsonIgnore
    private long photoId;
    private CameraParameter cameraParameter;
    private String color;

    public Photo() {
        setType(photo);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                "tag=" + getTags() +
                ", cameraParameter=" + cameraParameter +
                ", color='" + color + '\'' +
                '}';
    }
}
