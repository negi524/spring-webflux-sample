package com.example.springwebfluxsample.presentation.controller;

import com.example.springwebfluxsample.application.service.ExternalApiRequestService;
import com.example.springwebfluxsample.application.service.GeneratorService;
import com.example.springwebfluxsample.application.service.TodoService;
import com.example.springwebfluxsample.infrastructure.dto.response.HttpbinGetResponse;
import com.example.springwebfluxsample.presentation.dto.response.ErrorResponse;
import com.example.springwebfluxsample.presentation.dto.response.SimpleResponse;
import com.example.springwebfluxsample.presentation.dto.response.Todo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
public class SampleV1Controller {
  private final TodoService todoService;
  private final ExternalApiRequestService externalApiRequestService;
  private final GeneratorService generatorService;

  /**
   * jsonplaceholderから返却されるtodoオブジェクトを返却する
   *
   * @return todoオブジェクト
   */
  @GetMapping(value = "/todo")
  @Operation(summary = "JsonPlaceholderのデータを返却する", description = "JsonPlaceholderにプロキシし、レスポンスを返却する", tags = "外部API接続")
  @ApiResponse(responseCode = "200", description = "jsonplaceholderから返却されるtodoオブジェクト",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Todo.class)))
  public Mono<Todo> getTodo() {
    log.info("Todo request.");
    return todoService.fetchTodo();
  }

  /**
   * httpbinから返却されるオブジェクトを返却する
   *
   * @return httpbinオブジェクト
   */
  @GetMapping("/httpbin")
  @Operation(summary = "httpbinのデータを返却する", description = "httpbinにプロキシし、レスポンスを返却する", tags = "外部API接続")
  @ApiResponse(responseCode = "200", description = "httpbinから返却されるオブジェクト",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = HttpbinGetResponse.class)))
  public Mono<HttpbinGetResponse> getHttpbin() {
    log.info("Httpbin request.");
    return externalApiRequestService.fetch();
  }

  /**
   * サンプルで生成した文字列を返却する
   *
   * @return サンプルデータ
   */
  @GetMapping("/sample")
  @Operation(summary = "任意のサンプルデータを返却する", description = "任意のサンプルデータを生成し、ログ出力して返却する", tags = "任意コード")
  @ApiResponse(responseCode = "200", description = "生成したサンプルデータを返却する",
      content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SimpleResponse.class)))
  public Mono<SimpleResponse> getSample() {
    log.info("Sample request.");
    generatorService.getNameFlux()
        .subscribe(name -> log.info("Flux Name is: {}", name));

    generatorService.getNameMono()
        .subscribe(name -> log.info("Mono Name is: {}", name));
    final var response = new SimpleResponse("value");
    return Mono.just(response);
  }

  /**
   * 意図的に例外を発生させるエンドポイント
   *
   * @return エラーレスポンス
   */
  @GetMapping("/sampleError")
  @Operation(summary = "任意の例外を発生させる", description = "任意のサンプルコードを実行し、意図的にエラーを発生させる", tags = "任意コード")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "意図的に発生したエラーを返却する",
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SimpleResponse.class))),
      @ApiResponse(responseCode = "500", description = "意図的に発生したエラーを返却する",
          content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
  })
  public Mono<SimpleResponse> getSampleError() {
    log.error("Sample error request.");
    generatorService.generateError()
        .subscribe(name -> log.info("Mono Name is: {}", name));
    final var response = new SimpleResponse("value");
    return Mono.just(response);
  }
}
