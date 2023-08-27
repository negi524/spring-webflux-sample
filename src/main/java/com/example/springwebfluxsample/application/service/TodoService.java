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

  private final WebClient jsonPlaceholderClient;

  /**
   * <p>複数APIをリクエストして結果をマッシュアップする.</p>
   *
   * @return レスポンス用オブジェクト
   */
  public Mono<Todo> fetchTodo() {
    // APIリクエストする
    final Mono<TodoResponse> responseMono1 =
        jsonPlaceholderClient.get().uri("/posts/1").retrieve().bodyToMono(TodoResponse.class);
    final Mono<TodoResponse> responseMono2 =
        jsonPlaceholderClient.get().uri("/posts/78").retrieve().bodyToMono(TodoResponse.class);

    return Mono.zip(responseMono1, responseMono2, (response1, response2) -> {
      return Todo.builder()
          .id(response1.getId())
          .name(response2.getTitle())
          .build();
    });
  }
}
