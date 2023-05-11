package com.example.springwebfluxsample.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 任意のデータを生成する
 */
@Service
@RequiredArgsConstructor
public class GeneratorService {

  /**
   * 生成した名前を取得する
   *
   * @return 名前のリスト
   */
  public Flux<String> getNameFlux() {
    return Flux.fromIterable(List.of("alex", "ben", "chloe"));
  }

  public Mono<String> getNameMono() {
    return Mono.just("alex");
  }
}
