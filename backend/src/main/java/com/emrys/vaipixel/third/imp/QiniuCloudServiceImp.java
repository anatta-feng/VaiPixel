package com.emrys.vaipixel.third.imp;

import com.emrys.vaipixel.third.IQiniuCloudService;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;

public class QiniuCloudServiceImp implements IQiniuCloudService {

    @Value("${qiniu.accesskey}")
    String accessKey;

    @Value("${qiniu.secretKey}")
    String secretKey;

    @Value("${qiniu.bucket}")
    String bucket;

    public void getUploadAuth() {
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();
    }
}
