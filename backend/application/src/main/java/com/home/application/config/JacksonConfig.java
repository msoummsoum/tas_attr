package com.home.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jackson-config.properties")
public class JacksonConfig {
}
