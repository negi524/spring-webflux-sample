# spring-webflux-sample

## 起動方法

```bash
./gradlew bootRun
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