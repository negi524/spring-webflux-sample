package com.example.springwebfluxsample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter implements WebFilter {

  @Override
  public Mono<Void> filter(final ServerWebExchange exchange, final WebFilterChain chain) {
    log.info("status={}\tpath={}",
        exchange.getResponse().getStatusCode(), exchange.getRequest().getPath());
    return chain.filter(exchange);
  }
}
