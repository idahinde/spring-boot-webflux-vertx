package com.websculpture.springwebfluxvertx.config;

import io.vertx.core.VertxOptions;
import io.vertx.core.spi.VerticleFactory;
import io.vertx.mutiny.core.Vertx;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Idris Ishaq
 * @Date: 02 Nov, 2023
 */

@Configuration
public class VertxConfiguration {

    @Bean
    public Vertx vertx(VerticleFactory verticleFactory) {
        VertxOptions vertxOptions = new VertxOptions();
        vertxOptions.setWorkerPoolSize(35);
        Vertx vertx = Vertx.vertx(vertxOptions);
        vertx.registerVerticleFactory(verticleFactory);
        return vertx;
    }

}
