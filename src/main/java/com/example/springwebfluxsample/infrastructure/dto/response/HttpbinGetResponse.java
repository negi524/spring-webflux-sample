package com.example.springwebfluxsample.infrastructure.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

  @NonNull
  private final String origin;
  @NonNull
  private final String url;
}
