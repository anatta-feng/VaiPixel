package com.emrys.vaipixel.third.callbackcontroller;

import com.emrys.vaipixel.third.service.IThirdObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QiniuCloudCallbackController {

    private IThirdObjectStorageService objectStorageService;

    @Autowired
    public QiniuCloudCallbackController(IThirdObjectStorageService objectStorageService) {
        this.objectStorageService = objectStorageService;
    }

    @RequestMapping("callback/qiniuCloud/upload")
    public QiniuCloudCallbackPojo callback(QiniuCloudCallbackPojo pojo) {
        objectStorageService.setResourceDeadline("", 3600);
        return pojo;
    }
}
