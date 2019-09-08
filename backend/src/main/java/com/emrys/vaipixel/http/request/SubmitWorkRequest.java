package com.emrys.vaipixel.http.request;

import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.emrys.vaipixel.db.model.CameraParameter;

import java.util.List;

public class SubmitWorkRequest extends VaiPixelRequest {
    private String key;
    private String title;
    private String description;
    private long authorId;
    private WorkTypeEnum type;
    private List<String> tags;
    private String category;
    private CameraParameter equipment;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public WorkTypeEnum getType() {
        return type;
    }

    public void setType(WorkTypeEnum type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CameraParameter getEquipment() {
        return equipment;
    }

    public void setEquipment(CameraParameter equipment) {
        this.equipment = equipment;
    }
}
