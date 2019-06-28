package com.emrys.vaipixel.third.imp;

import com.emrys.vaipixel.third.IQiniuCloudService;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class QiniuCloudServiceImp implements IQiniuCloudService {
    String accessKey = "access key";
    String secretKey = "secret key";
    String bucket = "bucket name";

    public void getUploadAuth() {
        Auth auth = Auth.create(accessKey, secretKey);
        StringMap putPolicy = new StringMap();

    }
}
