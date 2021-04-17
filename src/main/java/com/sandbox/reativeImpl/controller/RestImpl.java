package com.sandbox.reativeImpl.controller;


import com.sandbox.reativeImpl.model.GreetingResponse;
import com.sandbox.reativeImpl.model.Stocks;
import com.sandbox.reativeImpl.service.CustomService;
import com.sandbox.reativeImpl.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RestImpl {

    @Autowired
    CustomService customService;

    @Autowired
    GreetingService greetingService;

     @GetMapping(path = "/greet/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<GreetingResponse> greet(@PathVariable String name) throws InterruptedException {
        return greetingService.greet(name);
    }





}
