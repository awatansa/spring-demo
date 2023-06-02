package com.vyira.apis.weather.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    @JsonProperty(value = "href", access = JsonProperty.Access.READ_WRITE)
    private String href;

    @JsonProperty("@type")
    private String type;
}
