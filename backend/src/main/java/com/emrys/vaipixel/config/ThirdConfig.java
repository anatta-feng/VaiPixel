package com.emrys.vaipixel.config;

import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdConfig {

    @Bean
    public Auth getQiniuCloudAuth(@Value("${qiniu.accesskey}") String accessKey,
                                  @Value("${qiniu.serectkey}") String secretKey) {
        return Auth.create(accessKey, secretKey);
    }
}
