package com.example.springwebfluxsample.application.service;

import com.example.springwebfluxsample.infrastructure.dto.response.TodoResponse;
import com.example.springwebfluxsample.presentation.dto.response.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TodoService {

  private final WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

  /**
   * オブジェクトをリクエストしてコンバートする
   *
   * @return レスポンス用オブジェクト
   */
  public Mono<Todo> fetchTodo() {
    // APIリクエストする
    final Mono<TodoResponse> responseMono =
        client.get().uri("/posts/1").retrieve().bodyToMono(TodoResponse.class);

    return responseMono.flatMap(
        todoResponse -> Mono
            .just(Todo.builder()
                .id(todoResponse.getId())
                .name(todoResponse.getTitle())
                .build()));
  }
}
