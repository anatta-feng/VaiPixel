package com.emrys.vaipixel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaiPixelConfig {

    @Bean(name = "workId")
    public long workId() {
        return 1L;
    }

    @Bean(name = "dataCenterId")
    public long dataCenterId() {
        return 1L;
    }
}
