package com.example.springwebfluxsample.infrastructure.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * FirebaseのIDTokenを送信するリクエストボディ
 */
@Getter
@RequiredArgsConstructor
public class FirebaseIdTokenBody {
  /**
   * IDトークン
   */
  private final String idToken;
}

