package com.example.springwebfluxsample.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class SimpleResponse {

  /**
   * key=valueのデータ
   */
  @NonNull
  @Schema(description = "key", requiredMode = Schema.RequiredMode.AUTO, example = "value")
  private final String key;
}
