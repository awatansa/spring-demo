package com.vyira.apis.weather.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "vyira.datasource")
public class ApplicationProperties {
    private String user;
    private String password;
    private String url;
}
