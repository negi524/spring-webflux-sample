package com.example.springwebfluxsample.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

/**
 * エラーレスポンス
 */
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ErrorResponse implements Serializable {

  /**
   * エラーコード
   */
  @NonNull
  @Schema(requiredMode = Schema.RequiredMode.AUTO, description = "エラーコード", example = "500")
  private final Integer code;
  /**
   * エラーメッセージ
   */
  @NonNull
  @Schema(requiredMode = Schema.RequiredMode.AUTO, description = "エラーメッセージ", example = "エラーが発生しました")
  private final String message;

  /**
   * ファクトリメソッド
   *
   * @param code    エラーコード
   * @param message エラーメッセージ
   * @return ErrorResponse
   */
  @NonNull
  public static ErrorResponse of(final Integer code, final String message) {
    return new ErrorResponse(code, message);
  }
}
