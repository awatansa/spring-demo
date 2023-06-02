package com.vyira.apis.weather.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConversionException extends RuntimeException {
    private int code;
    private String message;

    public ConversionException(Exception e) {
        super(e);
    }

    public ConversionException(String message, Exception e) {
        super(message, e);
        this.code = 0;
        this.message = message;
    }

    public ConversionException(int code, String message, Exception e) {
        super(message, e);
        this.code = code;
        this.message = message;
    }
}
