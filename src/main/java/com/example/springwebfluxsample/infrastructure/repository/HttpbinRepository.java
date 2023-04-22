package com.example.springwebfluxsample.infrastructure.repository;

import com.example.springwebfluxsample.infrastructure.dto.response.HttpbinGetResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * httpbin.orgに対するリクエスト
 */
@Repository
public class HttpbinRepository {

  private static final WebClient WEB_CLIENT = WebClient.create("https://httpbin.org/get");

  /**
   * {@inheritDoc}
   *
   * @return
   */
  public Mono<HttpbinGetResponse> get() {
    return WEB_CLIENT.get().retrieve().bodyToMono(HttpbinGetResponse.class);
  }
}
