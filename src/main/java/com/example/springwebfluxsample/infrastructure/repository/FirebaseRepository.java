package com.example.springwebfluxsample.infrastructure.repository;

import com.example.springwebfluxsample.config.FirebaseProperties;
import com.example.springwebfluxsample.infrastructure.dto.request.FirebaseIdTokenBody;
import com.example.springwebfluxsample.infrastructure.dto.request.FirebaseSignUpBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FirebaseRepository {

  private final FirebaseProperties firebaseProperties;
  private final WebClient firebaseClient;

  /**
   * ユーザーを新規作成する
   * @return 新規作成されたユーザーのIDトークン
   */
  public Mono<String> signUp() {
    final FirebaseSignUpBody body = new FirebaseSignUpBody("test@example.com", "Passw0rd", true);
    return firebaseClient
        .post()
        .uri(uriBuilder -> uriBuilder
            .path(firebaseProperties.getSignUpPath())
            .queryParam("key", firebaseProperties.getApiKey())
            .build())
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .retrieve()
        .bodyToMono(String.class)
        .log();
  }

  /**
   * ユーザーデータを参照する
   * @param idToken IDトークン
   * @return ユーザー情報
   */
  @NonNull
  public Mono<String> getUser(final String idToken) {
    final FirebaseIdTokenBody body = new FirebaseIdTokenBody(idToken);
    return firebaseClient
        .post()
        .uri(uriBuilder -> uriBuilder
            .path(firebaseProperties.getLookUpPath())
            .queryParam("key", firebaseProperties.getApiKey())
            .build())
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(body)
        .retrieve()
        .bodyToMono(String.class)
        .log();
  }
}
