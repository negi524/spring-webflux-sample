# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

Spring WebFlux を使用したリアクティブ Web アプリケーションのサンプルプロジェクト。外部 API（JSONPlaceholder、httpbin）へのプロキシリクエストを実装している。

## 開発コマンド

```bash
# アプリケーション起動
./gradlew bootRun

# プロファイル指定で起動
./gradlew bootRun --args='--spring.profiles.active=local'

# テスト実行
./gradlew test

# 単一テストクラス実行
./gradlew test --tests "com.example.springwebfluxsample.SomeTest"

# Checkstyle 実行
./gradlew checkstyleMain checkstyleTest

# ビルド
./gradlew build
```

## アーキテクチャ

レイヤードアーキテクチャを採用:

```
presentation/     # Controller, DTO (リクエスト/レスポンス)
  └── controller/   # REST エンドポイント (@RestController)
  └── dto/          # プレゼンテーション層の DTO
  └── handler/      # 例外ハンドラ
application/      # Service (ビジネスロジック)
  └── service/      # WebClient を使用した外部 API 呼び出しのオーケストレーション
infrastructure/   # Repository, 外部 API 用 DTO
  └── repository/   # 外部 API クライアント実装
  └── dto/          # 外部 API レスポンス用 DTO
config/           # Bean 定義、フィルタ設定
exception/        # カスタム例外
```

## 技術スタック

- Java 18, Spring Boot 3.2.3, Spring WebFlux
- Reactor (Mono/Flux) によるリアクティブプログラミング
- Lombok（@RequiredArgsConstructor, @Builder 等）
- SpringDoc OpenAPI (Swagger UI): `http://localhost:8080/webjars/swagger-ui/index.html`
- Micrometer + Prometheus（メトリクス）、Brave（トレーシング）
- Checkstyle (Google スタイル): `config/google_checks.xml`

## WebClient 設定

`WebClientConfig` で外部 API クライアントを Bean 定義:
- `jsonPlaceholderClient`: JSONPlaceholder API
- `httpbinClient`: httpbin API

## 動作確認エンドポイント

- ヘルスチェック: `GET /actuator/health`
- メトリクス: `GET /actuator/prometheus`
- サンプル API: `GET /v1/sample`, `GET /v1/todo`, `GET /v1/httpbin`
