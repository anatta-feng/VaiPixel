package com.emrys.vaipixel;

import com.emrys.vaipixel.config.CommonConfig;
import com.emrys.vaipixel.config.InterceptorConfig;
import com.emrys.vaipixel.config.ThirdConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonConfig.class, ThirdConfig.class, InterceptorConfig.class})
public class VaiPixelConfig {

}
