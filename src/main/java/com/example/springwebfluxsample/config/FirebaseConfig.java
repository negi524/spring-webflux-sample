package com.example.springwebfluxsample.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Slf4j
@Configuration
public class FirebaseConfig {

  @Bean
  public FirebaseApp firebaseApp() {
    try (InputStream serviceAccount = new ClassPathResource("firebase-credential.json")
        .getInputStream()) {
      final FirebaseOptions options = FirebaseOptions.builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .build();
      return FirebaseApp.initializeApp(options);
    } catch (final Exception exception) {
      log.error("FirebaseAppの生成に失敗しました", exception);
    }
    return FirebaseApp.initializeApp();
  }
}
