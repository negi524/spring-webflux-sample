# API エンドポイント一覧

## アプリケーション

| メソッド | パス | 期待ステータス | レスポンスキー |
|---------|------|-------------|-------------|
| GET | `/v1/sample` | 200 | `key` |
| GET | `/v1/todo` | 200 | `id`, `name` |
| GET | `/v1/httpbin` | 200 | `origin`, `url` |
| GET | `/v1/sampleError` | 500 | `code` (=1), `message` |

## 管理

| メソッド | パス | 期待ステータス |
|---------|------|-------------|
| GET | `/actuator/health` | 200 |
| GET | `/actuator/prometheus` | 200 |

## 外部API依存

| エンドポイント | 依存先 |
|-------------|-------|
| `/v1/todo` | `https://jsonplaceholder.typicode.com/posts/1`, `/posts/78` |
| `/v1/httpbin` | `https://httpbin.org/get` |
