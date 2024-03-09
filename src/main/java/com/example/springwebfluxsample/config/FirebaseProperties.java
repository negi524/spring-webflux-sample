package com.example.springwebfluxsample.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "extension.firebase")
public class FirebaseProperties {

  /**
   * ベースURL
   */
  final String baseUrl;
  /**
   * サインアップのパス
   */
  final String signUpPath;
  /**
   * ユーザーデータ参照のパス
   */
  final String lookUpPath;
  /**
   * APIキー
   */
  final String apiKey;

  /**
   * firebaseのWebClient
   *
   * @param builder WebClientBuilder
   * @return WebClient
   */
  @Bean
  public WebClient firebaseClient(final WebClient.Builder builder) {
    return builder
        .baseUrl(baseUrl)
        .build();
  }
}
