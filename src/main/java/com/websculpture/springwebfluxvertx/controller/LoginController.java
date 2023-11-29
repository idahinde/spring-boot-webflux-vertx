package com.websculpture.springwebfluxvertx.controller;

import com.websculpture.springwebfluxvertx.model.PhoneNumberObject;
import com.websculpture.springwebfluxvertx.model.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author: Idris Ishaq
 * @Date: 02 Nov, 2023
 */

@RestController
@AllArgsConstructor
public class LoginController {

    @PostMapping(value = "/v1/login", consumes = "application/json")
    public Mono<ResponseEntity<ResponseData>> save(@RequestBody PhoneNumberObject numberObject) {
        return Mono.just(ResponseEntity.status(200).body(ResponseData.of()));
    }

}
