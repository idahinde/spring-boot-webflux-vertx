package com.websculpture.springwebfluxvertx.verticle;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.vertx.core.AbstractVerticle;
import org.springframework.stereotype.Component;

/**
 * @Author: Idris Ishaq
 * @Date: 29 Nov, 2023
 */

@Component
public class ConfigurationVerticle extends AbstractVerticle {

    @Override
    public Uni<Void> asyncStart() {
        return super.asyncStart();
    }

}
