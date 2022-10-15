# spring-webflux-sample

## 起動方法

```bash
./gradlew bootRun
```

動作確認

```bash
$ curl -XGET "http://localhost:8080/actuator/health"
{"status":"UP"}
```