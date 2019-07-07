package com.emrys.vaipixel.third.service.imp;

import com.emrys.vaipixel.third.service.IThirdObjectStorageService;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QiniuCloudServiceImp implements IThirdObjectStorageService {

    @Value("${qiniu.bucket}")
    String bucket;

    private Auth auth;

    private String callbackUrl = "http://requestbin.fullcontact.com/1gwe6441";
    private String callbackBodyType = "application/json";

    private long expireSeconds = 1;

    private String callbackBody = "{" +
            "\"key\":\"$(key)\"," +
            "\"hash\":\"$(etag)\"," +
            "\"bucket\":\"$(bucket)\"," +
            "\"fsize\":$(fsize)," +
            "\"exif\":${exif}" +
            "}";

    private String returnBody = "{" +
            "\"key\":\"$(key)\"," +
            "\"hash\":\"$(etag)\"," +
            "\"bucket\":\"$(bucket)\"," +
            "\"fsize\":$(fsize)," +
            "\"exif\":${exif}" +
            "}";


    @Autowired
    public QiniuCloudServiceImp(Auth auth) {
        this.auth = auth;
    }

    @Override
    public String getUploadAuth() {
        StringMap putPolicy = new StringMap();
        putPolicy.put("callbackUrl", callbackUrl);
        putPolicy.put("callbackBody", callbackBody);
        putPolicy.put("callbackBodyType", callbackBodyType);
        putPolicy.put("returnBody", returnBody);
        return auth.uploadToken(bucket, null, expireSeconds, putPolicy);
    }

    @Override
    public void setResourceDeadline(String key, int day) {
        Configuration configuration = new Configuration();
        BucketManager bucketManager = new BucketManager(auth, configuration);
        try {
            bucketManager.deleteAfterDays(bucket, key, day);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeResourceDeadline(String key) {
        setResourceDeadline(key, 0);
    }

}
