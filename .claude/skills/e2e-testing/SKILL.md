---
name: e2e-testing
description: 起動中のアプリケーションに対してcurlでE2Eデグレチェックを実行するスキル。全エンドポイントにリクエストを送り、ステータスコード・レスポンス構造を検証する。「E2Eテスト」「デグレチェック」「動作確認」「エンドポイント確認」「curlでテスト」などのリクエスト時に使用。
---

# E2Eデグレチェック

curlでアプリケーションの全エンドポイントにリクエストし、デグレッションがないか確認する。

## 前提条件

- アプリケーションが起動済みであること
- デフォルトポート: `8080`
- 起動コマンド: `./gradlew bootRun`

## 実行手順

### 1. ヘルスチェック

まずアプリが起動しているか確認する。

```bash
curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/actuator/health
```

- 期待: `200`
- 起動していない場合はユーザーに起動を促す

### 2. 全エンドポイントのデグレチェック

以下を順にBashツールで実行し、結果を検証する。

#### GET /v1/sample

```bash
curl -s -w "\n%{http_code}" http://localhost:8080/v1/sample
```

**検証項目:**
- ステータスコード: `200`
- レスポンスにJSONキー `key` が存在すること

#### GET /v1/todo

```bash
curl -s -w "\n%{http_code}" http://localhost:8080/v1/todo
```

**検証項目:**
- ステータスコード: `200`
- レスポンスにJSONキー `id` (数値) と `name` (文字列) が存在すること

#### GET /v1/httpbin

```bash
curl -s -w "\n%{http_code}" http://localhost:8080/v1/httpbin
```

**検証項目:**
- ステータスコード: `200`
- レスポンスにJSONキー `origin` と `url` が存在すること

#### GET /v1/sampleError

```bash
curl -s -w "\n%{http_code}" http://localhost:8080/v1/sampleError
```

**検証項目:**
- ステータスコード: `500`
- レスポンスにJSONキー `code` (値: `1`) と `message` が存在すること

### 3. 結果レポート

全テスト完了後、以下の形式で結果を報告する。

```
## E2Eデグレチェック結果

| エンドポイント | ステータス | レスポンス検証 | 結果 |
|--------------|----------|-------------|------|
| GET /actuator/health | 200 | - | OK |
| GET /v1/sample | 200 | key存在 | OK |
| GET /v1/todo | 200 | id, name存在 | OK |
| GET /v1/httpbin | 200 | origin, url存在 | OK |
| GET /v1/sampleError | 500 | code=1, message存在 | OK |

全 5/5 テスト OK - デグレなし
```

失敗があった場合は、期待値と実際の値の差分を明示する。

## 注意事項

- `/v1/todo` と `/v1/httpbin` は外部API（JSONPlaceholder, httpbin.org）に依存するため、外部API障害時は失敗する可能性がある
- 外部API起因の失敗は、レスポンスの内容からアプリ側の問題か外部API側の問題かを切り分けて報告する
