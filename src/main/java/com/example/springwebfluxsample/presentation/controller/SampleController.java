package com.example.springwebfluxsample.presentation.controller;

import com.example.springwebfluxsample.application.service.ExternalApiRequestService;
import com.example.springwebfluxsample.application.service.GeneratorService;
import com.example.springwebfluxsample.application.service.TodoService;
import com.example.springwebfluxsample.infrastructure.dto.response.HttpbinGetResponse;
import com.example.springwebfluxsample.presentation.dto.response.Todo;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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

  /**
   * jsonplaceholderから返却されるtodoオブジェクトを返却する
   *
   * @return todoオブジェクト
   */
  @GetMapping("/todo")
  @ApiResponse(responseCode = "200", description = "jsonplaceholderから返却されるtodoオブジェクトを返却する",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Todo.class)))
  public Mono<Todo> getTodo() {
    return todoService.fetchTodo();
  }

  /**
   * httpbinから返却されるオブジェクトを返却する
   *
   * @return httpbinオブジェクト
   */
  @GetMapping("/httpbin")
  @ApiResponse(responseCode = "200", description = "jsonplaceholderから返却されるtodoオブジェクトを返却する",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpbinGetResponse.class)))
  public Mono<HttpbinGetResponse> getHttpbin() {
    return externalApiRequestService.fetch();
  }

  /**
   * サンプルで生成した文字列を返却する
   *
   * @return サンプルデータ
   */
  @GetMapping("/sample")
//  @ApiResponse(responseCode = "200", description = "生成したサンプルデータを返却する",
//      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
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
//  @ApiResponse(responseCode = "200", description = "意図的に発生したエラーを返却する",
//      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
  public Mono<String> getSampleError() {
    generatorService.generateError()
        .subscribe(name -> log.info("Mono Name is: {}", name));
    return Mono.just("OK");
  }
}
