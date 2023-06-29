package com.vyira.apis.weather.models.internals;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class Weather {
    @MongoId
    @Field
    private String id;

    @Field
    private String area;

    @Field
    private String description;
}