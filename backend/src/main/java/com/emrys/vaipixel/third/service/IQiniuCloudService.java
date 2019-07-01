package com.emrys.vaipixel.third.service;

import com.qiniu.common.QiniuException;

public interface IQiniuCloudService {
    String getUploadAuth();

    void setResourceDeadline(String key, int day) throws QiniuException;

    void removeResourceDeadline(String key) throws QiniuException;
}
