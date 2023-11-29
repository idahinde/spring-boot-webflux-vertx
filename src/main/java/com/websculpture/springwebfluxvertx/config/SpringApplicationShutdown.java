package com.websculpture.springwebfluxvertx.config;

import io.vertx.mutiny.core.Vertx;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @Author: Idris Ishaq
 * @Date: 29 Nov, 2023
 */

@Component
@AllArgsConstructor
public class SpringApplicationShutdown implements DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringApplicationShutdown.class);

    private final Vertx vertx;

    @Override
    public void destroy() throws Exception {
        vertx.close()
                .subscribe()
                .with(unused -> LOGGER.info("Vertx Application Context Shutdown Successfully!"),
                        throwable -> LOGGER.error("Vertx Shutdown", throwable));
    }

}
