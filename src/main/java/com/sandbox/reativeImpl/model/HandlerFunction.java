package com.sandbox.reativeImpl.model;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


/**
 *
 * The handle(..) method takes a ServerRequest and returns a Mono<ServerResponse>.
 * It is equivalent to a @Controller method annotated with @RequestMapping.
 * The ServerResponse accepts any Publisher<T> implementation as a body. Both ServerRequest and ServerResponse are immutable.
 * @param <T>
 */
@FunctionalInterface
public interface HandlerFunction<T extends ServerResponse> {
    Mono<T> handle(ServerRequest request);
}