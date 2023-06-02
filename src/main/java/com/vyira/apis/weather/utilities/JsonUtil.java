package com.vyira.apis.weather.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vyira.apis.weather.exceptions.ConversionException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Json Utility class for serialization and deserialization of objects
 *
 * @see ObjectMapper
 */
@Component
public class JsonUtil {
    private final ObjectMapper mapper;

    public JsonUtil(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T toObject(@NonNull String json, @NonNull Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new ConversionException(500, "Failed to parse json string", e);
        }
    }

    public <T> List<T> toObjectList(@NonNull String json, @NonNull Class<T[]> clazz) {
        try {
            return Arrays.asList(mapper.readValue(json, clazz));
        } catch (JsonProcessingException e) {
            throw new ConversionException(e);
        }
    }

    public String toJson(@NonNull Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ConversionException(e);
        }
    }
}
