package com.emrys.vaipixel.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import static com.emrys.vaipixel.db.enums.WorkTypeEnum.video;

@Data
public class Video extends Work {
    @JsonIgnore
    private long videoId;
    @JsonIgnore
    private long workId;
    private String deviceName;
    private String playUrl;

    public Video() {
        setType(video);
    }
}
