package com.emrys.vaipixel.third.callbackcontroller;

import com.emrys.vaipixel.db.model.CameraParameter;
import com.emrys.vaipixel.third.callbackcontroller.request.ExifInfo;
import com.emrys.vaipixel.third.callbackcontroller.request.ImageAve;
import com.emrys.vaipixel.third.callbackcontroller.request.QiniuCloudCallbackRequest;

public class QiniuCloudCallbackUtils {
    public static QiniuCloudCallbackResponse createQiniuCloudCallbackResponse(QiniuCloudCallbackRequest request) {
        QiniuCloudCallbackResponse response = new QiniuCloudCallbackResponse();
        response.setKey(request.getKey());
        response.setBucket(request.getBucket());
        response.setFsize(request.getFsize());
        response.setHash(request.getHash());

        ImageAve imageAve = request.getImageAve();
        response.setColor(imageAve.getRgb().replace("0x", "#"));

        ExifInfo exif = request.getExif();
        if (exif == null) {
            return response;
        } else {
            CameraParameter cameraParameter = new CameraParameter();
            cameraParameter.setMake(exif.getMake().getVal());
            cameraParameter.setModel(exif.getModel().getVal());
            cameraParameter.setAperture(exif.getfNumber().getVal());
            cameraParameter.setFocalLength(exif.getFocalLengthIn35MmFilm().getVal());
            cameraParameter.setShutter(exif.getExposureTime().getVal());
            cameraParameter.setIso(exif.getIsoSpeedRatings().getVal());
            return response;
        }
    }
}
