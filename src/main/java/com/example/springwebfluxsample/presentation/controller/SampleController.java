package com.example.springwebfluxsample.presentation.controller;

import com.example.springwebfluxsample.application.service.ExternalApiRequestService;
import com.example.springwebfluxsample.application.service.GeneratorService;
import com.example.springwebfluxsample.application.service.TodoService;
import com.example.springwebfluxsample.infrastructure.dto.response.HttpbinGetResponse;
import com.example.springwebfluxsample.presentation.dto.response.Todo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * サンプルコントローラー
 */
@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SampleController {
  private final TodoService todoService;
  private final ExternalApiRequestService externalApiRequestService;
  private final GeneratorService generatorService;

  @GetMapping("/todo")
//  @ApiOperation(value = "jsonplaceholderのtodo情報を取得する", notes = "詳細な説明はここに記述")
//  @ApiResponses(value = {
//      @ApiResponse(code = 400, message = "bad request", response = ErrorResponse.class)
//  })
  public Mono<Todo> getTodo() {
    return todoService.fetchTodo();
  }

  @GetMapping("/httpbin")
//  @ApiOperation(value = "jsonplaceholderのtodo情報を取得する", notes = "詳細な説明はここに記述")
  public Mono<HttpbinGetResponse> getHttpbin() {
    return externalApiRequestService.fetch();
  }

  @GetMapping("/sample")
//  @ApiOperation(value = "jsonplaceholderのtodo情報を取得する", notes = "詳細な説明はここに記述")
  public Mono<String> getSample() {
    generatorService.getNameFlux()
        .subscribe(name -> log.info("Flux Name is: {}", name));

    generatorService.getNameMono()
        .subscribe(name -> log.info("Mono Name is: {}", name));
    return Mono.just("OK");
  }

  /**
   * 意図的に例外を発生させるエンドポイント
   *
   * @return エラーレスポンス
   */
  @GetMapping("/sampleError")
//  @ApiOperation(value = "jsonplaceholderのtodo情報を取得する", notes = "詳細な説明はここに記述")
  public Mono<String> getSampleError() {
    generatorService.generateError()
        .subscribe(name -> log.info("Mono Name is: {}", name));
    return Mono.just("OK");
  }
}
