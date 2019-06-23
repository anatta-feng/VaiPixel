package com.emrys.vaipixel.db.model;

public class Photo extends Work {
    private long photoId;
    private long workId;
    private CameraParameter cameraParameter;

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    @Override
    public long getWorkId() {
        return workId;
    }

    @Override
    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public CameraParameter getCameraParameter() {
        return cameraParameter;
    }

    public void setCameraParameter(CameraParameter cameraParameter) {
        this.cameraParameter = cameraParameter;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", workId=" + workId +
                ", cameraParameter=" + cameraParameter +
                "} " + super.toString();
    }
}
