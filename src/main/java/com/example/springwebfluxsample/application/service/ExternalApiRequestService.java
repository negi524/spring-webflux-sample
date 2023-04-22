package com.example.springwebfluxsample.application.service;

import com.example.springwebfluxsample.infrastructure.dto.response.HttpbinGetResponse;
import com.example.springwebfluxsample.infrastructure.repository.HttpbinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * 外部のAPIにリクエストを行う
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalApiRequestService {

  private final HttpbinRepository httpbinRepository;

  public Mono<HttpbinGetResponse> fetch() {
    final var temp = httpbinRepository.get().log();
    return temp;
  }
}
