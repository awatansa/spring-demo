package com.vyira.apis.weather.services.business;

import com.vyira.apis.weather.models.internals.Weather;
import com.vyira.apis.weather.repository.WeatherRepository;
import com.vyira.apis.weather.services.subtasks.MainSubTaskService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class MainBusinessLogicService {
    private final MainSubTaskService subTaskService;
    private final WeatherRepository repository;

    public MainBusinessLogicService(MainSubTaskService subTaskService, WeatherRepository repository) {
        this.subTaskService = subTaskService;
        this.repository = repository;
    }


    @Timed
    public Mono<List<Weather>> handleRequest(String name) {
        subTaskService.run();
        return Flux.range(0, 500)
                .flatMap(i -> {
                    Weather weather = new Weather();
                    weather.setArea(UUID.randomUUID().toString());
                    weather.setDescription(UUID.randomUUID() + UUID.randomUUID().toString() + UUID.randomUUID());
                    log.debug("saving document={}", weather);
                    return repository.save(weather).map(result -> {
                        log.debug("resultId={}", result.getId());
                        return result;
                    });
                }).collectList();
    }
}
