package com.vyira.apis.weather.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

    @JsonProperty("id")
    private String id;

    @JsonProperty("value")
    private String value;

    @JsonProperty("name")
    private String name;
}
