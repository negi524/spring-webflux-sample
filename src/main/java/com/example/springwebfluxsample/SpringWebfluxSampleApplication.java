package com.example.springwebfluxsample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import reactor.core.publisher.Hooks;

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
@ConfigurationPropertiesScan
public class SpringWebfluxSampleApplication {

  public static void main(final String[] args) {
    Hooks.enableAutomaticContextPropagation();
    SpringApplication.run(SpringWebfluxSampleApplication.class, args);
  }
}
