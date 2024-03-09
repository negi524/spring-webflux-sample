package com.example.springwebfluxsample.infrastructure.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Firebaseユーザー登録のリクエストボディ
 */
@Getter
@RequiredArgsConstructor
public class FirebaseSignUpBody {
  /**
   * メールアドレス
   */
  private final String email;
  /**
   * パスワード
   */
  private final String password;
  /**
   * IDとリフレッシュトークンを返却するか
   */
  private final Boolean returnSecureToken;
}
