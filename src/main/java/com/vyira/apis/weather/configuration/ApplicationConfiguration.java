package com.vyira.apis.weather.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

@EnableAsync
@Configuration
@EnableConfigurationProperties
public class ApplicationConfiguration {

    @Bean
    @Primary
    public TaskExecutor getTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public AsyncTaskExecutor getAsyncTaskExecutor() {
        return new ConcurrentTaskExecutor();
    }

    @Bean
    public ObjectMapper getJsonObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter();
        return mapper;
    }
}
