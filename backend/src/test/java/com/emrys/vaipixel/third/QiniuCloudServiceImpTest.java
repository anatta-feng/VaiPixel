package com.emrys.vaipixel.third;

import com.emrys.vaipixel.BaseTest;
import com.qiniu.common.QiniuException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class QiniuCloudServiceImpTest extends BaseTest {

    @Autowired
    private IQiniuCloudService service;

    @Test
    public void getUploadAuth() {
        System.out.println(service.getUploadAuth());
    }
}