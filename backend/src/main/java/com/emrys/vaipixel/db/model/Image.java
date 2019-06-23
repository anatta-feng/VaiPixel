package com.emrys.vaipixel.db.model;

import java.io.Serializable;

public class Image implements Serializable {
    private String largeUrl;
    private String mediumUrl;
    private String smallUrl;
    private String thumbUrl;

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @Override
    public String toString() {
        return "Image{" +
                "largeUrl='" + largeUrl + '\'' +
                ", mediumUrl='" + mediumUrl + '\'' +
                ", smallUrl='" + smallUrl + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
                '}';
    }
}
