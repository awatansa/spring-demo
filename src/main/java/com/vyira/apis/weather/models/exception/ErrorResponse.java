package com.vyira.apis.weather.models.exception;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  @JsonProperty
  public int code;

  @JsonProperty
  public String message;

  @JsonProperty
  public String description;

  @JsonProperty
  public LocalDateTime timestamp;

  @JsonProperty
  public Map<String, String> additionalInformation;

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Uses MessageFormat.format() signature, pass the argurments accordingly
   * 
   * @param msg     string template
   * @param objects arguments
   * @see MessageFormat
   */
  public void setDescription(String msg, Object... objects) {
    this.description = MessageFormat.format(msg, objects);
  }
}
