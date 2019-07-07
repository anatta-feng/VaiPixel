package com.emrys.vaipixel.third;

import com.emrys.vaipixel.BaseTest;
import com.emrys.vaipixel.third.service.IThirdObjectStorageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QiniuCloudServiceImpTest extends BaseTest {

    @Autowired
    private IThirdObjectStorageService service;

    @Test
    public void getUploadAuth() {
        System.out.println(service.getUploadAuth());
    }
}