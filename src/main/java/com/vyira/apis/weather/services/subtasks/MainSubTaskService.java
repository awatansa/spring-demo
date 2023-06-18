package com.vyira.apis.weather.services.subtasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vyira.apis.weather.configuration.ApplicationProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainSubTaskService {

    private final ApplicationProperties properties;

    public MainSubTaskService(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Async
    public void run() {
        log.info("Running Simple Task");
        log.info("properties => user={}, pass={}, url={}", properties.getUser(), properties.getPassword(),
                properties.getUrl());
    }
}
