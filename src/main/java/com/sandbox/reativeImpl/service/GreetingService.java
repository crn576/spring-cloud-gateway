package com.sandbox.reativeImpl.service;


import com.sandbox.reativeImpl.model.GreetingResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class GreetingService {

    private GreetingResponse getGreeting(String name)  {

        return new GreetingResponse(name, " Hello " + name + Instant.now());
    }
 public Mono<GreetingResponse> greet( String name)   {
        return Mono.just(getGreeting(name));
    }
}
