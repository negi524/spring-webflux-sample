package com.example.springwebfluxsample.presentation.dto.response;

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
  private final Integer code;
  /**
   * エラーメッセージ
   */
  @NonNull
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
