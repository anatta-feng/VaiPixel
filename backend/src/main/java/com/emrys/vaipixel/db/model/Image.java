package com.emrys.vaipixel.db.model;

public class Image {
    private String rowUrl;
    private String fullUrl;
    private String regularUrl;
    private String smallUrl;
    private String thumbUrl;

    public String getRowUrl() {
        return rowUrl;
    }

    public void setRowUrl(String rowUrl) {
        this.rowUrl = rowUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getRegularUrl() {
        return regularUrl;
    }

    public void setRegularUrl(String regularUrl) {
        this.regularUrl = regularUrl;
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
}
