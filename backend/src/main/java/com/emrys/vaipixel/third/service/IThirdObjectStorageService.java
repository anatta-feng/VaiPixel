package com.emrys.vaipixel.third.service;

import com.qiniu.common.QiniuException;

public interface IThirdObjectStorageService {
    String getUploadAuth();

    void setResourceDeadline(String key, int day) throws QiniuException;

    void removeResourceDeadline(String key);
}
