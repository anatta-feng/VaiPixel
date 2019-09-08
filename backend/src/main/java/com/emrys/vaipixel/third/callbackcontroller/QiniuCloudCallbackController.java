package com.emrys.vaipixel.third.callbackcontroller;

import com.emrys.vaipixel.third.service.IThirdObjectStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QiniuCloudCallbackController {

    private IThirdObjectStorageService objectStorageService;

    @Autowired
    public QiniuCloudCallbackController(IThirdObjectStorageService objectStorageService) {
        this.objectStorageService = objectStorageService;
    }

    @RequestMapping(value = "callback/qiniuCloud/upload", method = RequestMethod.POST)
    public QiniuCloudCallbackPojo callback(@RequestBody QiniuCloudCallbackPojo  pojo) {
        System.out.println(pojo);
        objectStorageService.setResourceDeadline(pojo.getKey(), 3600);
        return pojo;
    }
}
