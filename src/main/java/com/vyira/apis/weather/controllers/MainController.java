package com.vyira.apis.weather.controllers;

import com.vyira.apis.weather.services.business.MainBusinessLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class MainController {

    private final MainBusinessLogicService service;

    public MainController(MainBusinessLogicService service) {
        this.service = service;
    }

    @GetMapping("test")
    public ResponseEntity<Object> handleGetRequest(@RequestParam String value) {
        log.info("API CALLED={}", value);
        return ResponseEntity.ok(service.handleRequest(value));
    }
}
