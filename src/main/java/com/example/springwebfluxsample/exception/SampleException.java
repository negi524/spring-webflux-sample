package com.example.springwebfluxsample.exception;

/**
 * サンプル例外
 */
public class SampleException extends RuntimeException {

  /**
   * コンストラクタ
   *
   * @param message 例外メッセージ
   */
  public SampleException(final String message) {
    super(message);
  }
}
