# spring-webflux-sample

## 起動方法

### 通常の起動

```bash
./gradlew bootRun
```

### プロファイル指定で起動

```bash
./gradlew bootRun --args='--spring.profiles.active=local'
```

もしくは、環境変数に以下を設定
```fish
set -x SPRING_PROFILES_ACTIVE local
```
or
```bash
export SPRING_PROFILES_ACTIVE=local
```

## 動作確認

### ヘルスチェック

```bash
$ curl -XGET "http://localhost:8080/actuator/health"
{"status":"UP"}
```

### サンプル

```bash
$ curl -XGET "http://localhost:8080/v1/sample"
{"key":"value"}
```


### Swagger

http://localhost:8080/webjars/swagger-ui/index.html
http://localhost:8080/v3/api-docs

### 静的コンテンツ

http://localhost:8080/sample.json