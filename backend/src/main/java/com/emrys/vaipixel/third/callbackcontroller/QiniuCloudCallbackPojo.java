package com.emrys.vaipixel.third.callbackcontroller;

public class QiniuCloudCallbackPojo {

    /**
     * key : DSC02064.jpg
     * hash : FqIKtuuOsvjTcjuxNN31qmufe05I
     * bucket : vaipixel
     * fsize : 3095143
     * exif : {"ApertureValue":{"type":5,"val":"2.64 EV (f/2.5)"},"Artist":{"type":2,"val":"emrys"},"BrightnessValue":{"type":10,"val":"2.31 EV (16.95 cd/m^2)"},"ColorSpace":{"type":3,"val":"sRGB"},"Contrast":{"type":3,"val":"Normal"},"Copyright":{"type":2,"val":"emrys (Photographer) -  (Editor)"},"CustomRendered":{"type":3,"val":"Normal process"},"DateTime":{"type":2,"val":"2019:07:13 14:54:56"},"DateTimeDigitized":{"type":2,"val":"2019:06:22 17:11:06"},"DateTimeOriginal":{"type":2,"val":"2019:06:22 17:11:06"},"DigitalZoomRatio":{"type":5,"val":"1.00"},"ExifVersion":{"type":7,"val":"Unknown Exif Version"},"ExposureBiasValue":{"type":10,"val":"0.00 EV"},"ExposureMode":{"type":3,"val":"Manual exposure"},"ExposureProgram":{"type":3,"val":"Manual"},"ExposureTime":{"type":5,"val":"1/1250 sec."},"FNumber":{"type":5,"val":"f/2.5"},"FileSource":{"type":7,"val":"DSC"},"Flash":{"type":3,"val":"Flash did not fire, compulsory flash mode"},"FlashPixVersion":{"type":7,"val":"FlashPix Version 1.0"},"FocalLength":{"type":5,"val":"56.0 mm"},"FocalLengthIn35mmFilm":{"type":3,"val":"84"},"FocalPlaneResolutionUnit":{"type":3,"val":"Centimeter"},"FocalPlaneXResolution":{"type":5,"val":"2553.19150"},"FocalPlaneYResolution":{"type":5,"val":"2553.19150"},"ISOSpeedRatings":{"type":3,"val":"1600"},"LightSource":{"type":3,"val":"Unknown"},"Make":{"type":2,"val":"SONY"},"MaxApertureValue":{"type":5,"val":"0.97 EV (f/1.4)"},"MeteringMode":{"type":3,"val":"Spot"},"Model":{"type":2,"val":"ILCE-6400"},"ResolutionUnit":{"type":3,"val":"Inch"},"Saturation":{"type":3,"val":"Normal"},"SceneCaptureType":{"type":3,"val":"Standard"},"SceneType":{"type":7,"val":"Directly photographed"},"Sharpness":{"type":3,"val":"Normal"},"ShutterSpeedValue":{"type":10,"val":"10.29 EV (1/1249 sec.)"},"Software":{"type":2,"val":"Adobe Photoshop Lightroom Classic 8.3.1 (Macintosh)"},"WhiteBalance":{"type":3,"val":"Auto white balance"},"XResolution":{"type":5,"val":"240"},"YResolution":{"type":5,"val":"240"},"thumbnail:Compression":{"type":3,"val":"JPEG compression"},"thumbnail:ResolutionUnit":{"type":3,"val":"Inch"},"thumbnail:XResolution":{"type":5,"val":"72"},"thumbnail:YResolution":{"type":5,"val":"72"}}
     */

    private String key;
    private String hash;
    private String bucket;
    private int fsize;
    private ExifInfo exif;

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

    public int getFsize() {
        return fsize;
    }

    public void setFsize(int fsize) {
        this.fsize = fsize;
    }

    public ExifInfo getExif() {
        return exif;
    }

    public void setExif(ExifInfo exif) {
        this.exif = exif;
    }
}
