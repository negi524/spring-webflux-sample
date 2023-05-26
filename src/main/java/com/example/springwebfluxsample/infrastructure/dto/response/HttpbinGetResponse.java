package com.example.springwebfluxsample.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

/**
 * https://httpbin.org/getのレスポンスクラス
 */
@Getter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpbinGetResponse {

  /**
   * アクセス元のIPアドレス
   */
  @NonNull
  @Schema(requiredMode = Schema.RequiredMode.AUTO, description = "アクセス元のIPアドレス", example = "192.0.2.0")
  private final String origin;
  /**
   * httpbinにアクセスしたときのURL
   */
  @NonNull
  @Schema
  private final String url;
}
