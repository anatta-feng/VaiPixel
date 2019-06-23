package com.emrys.vaipixel.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static com.emrys.vaipixel.db.enums.WorkTypeEnum.video;

public class Video extends Work {
    @JsonIgnore
    private long videoId;
    private String deviceName;
    private String playUrl;

    public Video() {
        setType(video);
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", deviceName='" + deviceName + '\'' +
                ", playUrl='" + playUrl + '\'' +
                "} " + super.toString();
    }
}
