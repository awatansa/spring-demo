package com.vyira.apis.weather.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

@EnableAsync
@Configuration
@EnableConfigurationProperties
@EnableMongoRepositories(basePackages = "com.vyira.apis.weather")
@EnableReactiveMongoRepositories(basePackages = "com.vyira.apis.weather")
public class ApplicationConfiguration {

    @Bean
    @Primary
    TaskExecutor getTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    AsyncTaskExecutor getAsyncTaskExecutor() {
        return new ConcurrentTaskExecutor();
    }

    @Bean
    ObjectMapper getJsonObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
