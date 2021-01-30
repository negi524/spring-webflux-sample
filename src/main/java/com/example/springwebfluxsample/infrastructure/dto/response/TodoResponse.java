package com.example.springwebfluxsample.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TodoResponse {
  private Integer userId;
  private Integer id;
  private String title;
}
