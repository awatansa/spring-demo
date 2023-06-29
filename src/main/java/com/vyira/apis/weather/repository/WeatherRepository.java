package com.vyira.apis.weather.repository;

import com.vyira.apis.weather.models.internals.Weather;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends ReactiveMongoRepository<Weather, String> {

}
