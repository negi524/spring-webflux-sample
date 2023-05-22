package com.example.springwebfluxsample.presentation.handler;

import com.example.springwebfluxsample.exception.SampleException;
import com.example.springwebfluxsample.presentation.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

  /**
   * SampleExceptionクラスのハンドリング
   *
   * @param sampleException 例外クラス
   * @return エラーレスポンス
   */
  @ExceptionHandler
  public Mono<ErrorResponse> handleException(final SampleException sampleException) {
    log.error("エラーが発生しました", sampleException);
    return Mono.just(ErrorResponse.of(1, "Sample exception"));
  }

  /**
   * Throwableクラスのハンドリング
   *
   * @param throwable 例外クラス
   * @return エラーレスポンス
   */
  @ExceptionHandler
  public Mono<ErrorResponse> handleException(final Throwable throwable) {
    log.error("エラーが発生しました", throwable);
    return Mono.just(ErrorResponse.of(999, "Unknown exception"));
  }
}
