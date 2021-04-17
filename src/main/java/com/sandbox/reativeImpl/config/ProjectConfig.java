package com.sandbox.reativeImpl.config;

import com.sandbox.reativeImpl.model.GreetingResponse;
import com.sandbox.reativeImpl.model.Stocks;
import com.sandbox.reativeImpl.service.CustomService;
import com.sandbox.reativeImpl.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.RouteMatcher;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProjectConfig {

  @Autowired
  CustomService customService;

  @Bean
  RouterFunction<ServerResponse> routes(GreetingService gs) {
    return route()
        .GET(
            "/newgreet/{name}",
            serverRequest -> {
              GreetingService gs1 = new GreetingService();
              Mono<GreetingResponse> responseMono = gs1.greet(serverRequest.pathVariable("name"));
              return ServerResponse.ok().body(responseMono, GreetingResponse.class);
            })
        .GET(
            "/stocks/all",
            serverRequest ->
                ServerResponse.ok().body(Mono.just(customService.getStocks()), List.class))
        .GET(
            "/stocks/{stockSymbol}",
            serverRequest ->
                ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(
                        Mono.just(
                            customService.getStockData(serverRequest.pathVariable("stockSymbol"))),
                        Stocks.class))
        .build();
  }
}
