package com.vyira.apis.weather.controllers.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vyira.apis.weather.exceptions.ConversionException;
import com.vyira.apis.weather.models.exception.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

  @ExceptionHandler
  public ResponseEntity<Object> handleException(Exception e) {
    log.error("Returning Exception to requester with no details, coz even you have not handled it properly!", e);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler
  public ResponseEntity<Object> handleConvertionException(ConversionException e) {
    log.error("converion of one or more objects failed", e);
    ErrorResponse response = new ErrorResponse();
    response.setCode(500);
    response.setMessage("conversion of an attribute to its respective object failed.");
    response.setTimestamp(LocalDateTime.now());
    response.setDescription("error={0}, cause={1}", e.getMessage(), e.getCause().toString());
    return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
