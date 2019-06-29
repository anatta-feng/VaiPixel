package com.emrys.vaipixel;

import com.emrys.vaipixel.config.ThirdConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import(ThirdConfig.class)
public class VaiPixelConfig {


}
