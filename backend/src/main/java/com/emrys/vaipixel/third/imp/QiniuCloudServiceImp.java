package com.emrys.vaipixel.third.imp;

import com.emrys.vaipixel.third.IQiniuCloudService;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QiniuCloudServiceImp implements IQiniuCloudService {

    @Value("${qiniu.bucket}")
    String bucket;

    private Auth auth;

    @Autowired
    public QiniuCloudServiceImp(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String getUploadAuth() {
        StringMap putPolicy = new StringMap();
        return auth.uploadToken(bucket, null, 10, putPolicy);
    }
}
