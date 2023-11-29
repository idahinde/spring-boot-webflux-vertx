package com.websculpture.springwebfluxvertx.controller;

import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author: Idris Ishaq
 * @Date: 29 Nov, 2023
 */

@RestController
@AllArgsConstructor
public class HomeController {

    @GetMapping(value = "/", produces = "application/json")
    public Mono<ResponseEntity<JsonObject>> home() {
        return Mono.just(ResponseEntity.ok(new JsonObject()
                .put("message", "Welcome to Spring Web Flux with Vertx.")));
    }

}
