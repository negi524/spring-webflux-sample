package com.example.springwebfluxsample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * WebClientをBean登録するためのクラス
 */
@Configuration
public class WebClientConfig {


  /**
   * JSONPlaceholderのWebClient
   *
   * @param builder WebClientBuilder
   * @return WebClient
   */
  @Bean
  public WebClient jsonPlaceholderClient(final WebClient.Builder builder) {
    return builder
        .baseUrl("https://jsonplaceholder.typicode.com")
        .build();
  }

  /**
   * httpbinのWebClient
   *
   * @param builder WebClientBuilder
   * @return WebClient
   */
  @Bean
  public WebClient httpbinClient(final WebClient.Builder builder) {
    return builder
        .baseUrl("https://httpbin.org/get")
        .build();
  }
}
