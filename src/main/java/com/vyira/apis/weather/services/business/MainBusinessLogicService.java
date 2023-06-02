package com.vyira.apis.weather.services.business;

import com.vyira.apis.weather.services.subtasks.MainSubTaskService;
import org.springframework.stereotype.Service;

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
