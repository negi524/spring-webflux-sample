package com.example.springwebfluxsample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * サンプルコード
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "サンプルAPI",
    description = "サンプルAPIの説明文",
    version = "v1"
)
)
public class SpringWebfluxSampleApplication {

  public static void main(final String[] args) {
    SpringApplication.run(SpringWebfluxSampleApplication.class, args);
  }
}
