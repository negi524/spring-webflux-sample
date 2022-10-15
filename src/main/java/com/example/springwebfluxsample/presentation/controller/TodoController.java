package com.example.springwebfluxsample.presentation.controller;

import com.example.springwebfluxsample.application.service.TodoService;
import com.example.springwebfluxsample.presentation.dto.response.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class TodoController {
  private final TodoService service;

  @GetMapping("/todo")
  public Mono<Todo> getTodo() {
    return service.fetchTodo();
  }

  @GetMapping("/sample")
  public Mono<String> getSample() {
    return Mono.just("sample");
  }
}
