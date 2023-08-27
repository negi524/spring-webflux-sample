package com.example.springwebfluxsample.infrastructure.repository;

import com.example.springwebfluxsample.infrastructure.dto.response.HttpbinGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * httpbin.orgに対するリクエスト
 */
@Repository
@RequiredArgsConstructor
public class HttpbinRepository {

  private final WebClient httpbinClient;

  /**
   * {@inheritDoc}
   *
   * @return
   */
  public Mono<HttpbinGetResponse> get() {
    return httpbinClient.get().retrieve().bodyToMono(HttpbinGetResponse.class);
  }
}
