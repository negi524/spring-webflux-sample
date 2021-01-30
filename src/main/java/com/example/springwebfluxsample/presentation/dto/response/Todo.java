package com.example.springwebfluxsample.presentation.dto.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class Todo {
  Integer id;
  String name;
}
