package com.emrys.vaipixel.db.model;

public class CameraParameter {
    /**
     * 相机
     */
    private String camera;
    /**
     * 镜头
     */
    private String lens;
    /**
     * 焦距
     */
    private int focalLength;
    /**
     * 光圈
     */
    private String aperture;
    /**
     * iso
     */
    private int iso;

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }
}
