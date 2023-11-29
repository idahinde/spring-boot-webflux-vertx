package com.websculpture.springwebfluxvertx.config;

import com.websculpture.springwebfluxvertx.verticle.ConfigurationVerticle;
import io.vertx.core.spi.VerticleFactory;
import io.vertx.mutiny.core.Vertx;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Idris Ishaq
 * @Date: 29 Nov, 2023
 */

@Component
@AllArgsConstructor
public class SpringApplicationBootstrap implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(SpringApplicationBootstrap.class);

    private final Vertx vertx;
    private final VerticleFactory verticleFactory;

    @Override
    public void run(String... args) throws Exception {
        String verticleName = String.format("%s:%s", verticleFactory.prefix(), ConfigurationVerticle.class.getName());
        vertx.deployVerticle(verticleName)
                .subscribe()
                .with(s -> LOGGER.info("Deploy Verticle Successfully: {}", s),
                        throwable -> LOGGER.error("Deploy Verticle", throwable));
    }

}
