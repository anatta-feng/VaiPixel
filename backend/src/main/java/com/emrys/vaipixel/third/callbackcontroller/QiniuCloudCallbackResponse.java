package com.emrys.vaipixel.third.callbackcontroller;

import com.emrys.vaipixel.db.model.CameraParameter;

public class QiniuCloudCallbackResponse {
    private String key;
    private String hash;
    private String bucket;
    private String color;
    private int fsize;
    private CameraParameter exif;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFsize() {
        return fsize;
    }

    public void setFsize(int fsize) {
        this.fsize = fsize;
    }

    public CameraParameter getExif() {
        return exif;
    }

    public void setExif(CameraParameter exif) {
        this.exif = exif;
    }
}
