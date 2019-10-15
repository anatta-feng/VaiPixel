package com.emrys.vaipixel.db.model;


import com.emrys.vaipixel.db.enums.WorkTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class Work implements Serializable {
    private long id;
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
}
