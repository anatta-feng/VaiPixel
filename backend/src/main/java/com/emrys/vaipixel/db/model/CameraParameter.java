package com.emrys.vaipixel.db.model;

import java.io.Serializable;

public class CameraParameter implements Serializable {
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
    private int aperture;
    /**
     * iso
     */
    private int iso;
    /**
     * 快门时间
     */
    private String shutter;

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

    public int getAperture() {
        return aperture;
    }

    public void setAperture(int aperture) {
        this.aperture = aperture;
    }

    public int getIso() {
        return iso;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public String getShutter() {
        return shutter;
    }

    public void setShutter(String shutter) {
        this.shutter = shutter;
    }
}
