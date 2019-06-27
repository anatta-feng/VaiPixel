package com.emrys.vaipixel.db.model;

import java.io.Serializable;

public class CameraParameter implements Serializable {
    /**
     * 相机厂商
     */
    private String make;
    /**
     * 相机型号
     */
    private String model;
    /**
     * 镜头
     */
    private String lens;
    /**
     * 焦距
     */
    private String focalLength;
    /**
     * 光圈
     */
    private String aperture;
    /**
     * iso
     */
    private String iso;
    /**
     * 快门时间
     */
    private String shutter;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getShutter() {
        return shutter;
    }

    public void setShutter(String shutter) {
        this.shutter = shutter;
    }

    @Override
    public String toString() {
        return "CameraParameter{" +
                "make='" + make + '\'' +
                ", lens='" + lens + '\'' +
                ", focalLength=" + focalLength +
                ", aperture=" + aperture +
                ", iso=" + iso +
                ", shutter='" + shutter + '\'' +
                '}';
    }
}
