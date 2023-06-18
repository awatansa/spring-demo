package com.vyira.apis.weather.services.business;

import org.springframework.stereotype.Service;

import com.vyira.apis.weather.services.subtasks.MainSubTaskService;

@Service
public class MainBusinessLogicService {
    private final MainSubTaskService subTaskService;

    public MainBusinessLogicService(MainSubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    public String handleRequest(String name) {
        subTaskService.run();
        return name.toUpperCase();
    }
}
