package com.websculpture.springwebfluxvertx.config;

import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.sqlclient.PoolOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Idris Ishaq
 * @Date: 18 Sep, 2023
 */

@Configuration
public class PostgresDbConfig {

    @Value("${abaa.db.host}")
    private String host;
    @Value("${abaa.db.port}")
    private int port;
    @Value("${abaa.db.username}")
    private String username;
    @Value("${abaa.db.password}")
    private String password;
    @Value("${abaa.db.db-name}")
    private String dbName;

    @Bean
    @Autowired
    public PgPool pgPool(Vertx vertx) {
        PgConnectOptions connectOptions = new PgConnectOptions()
                .setPort(port)
                .setHost(host)
                .setDatabase(dbName)
                .setUser(username)
                .setPassword(password);

        // Pool options
        PoolOptions poolOptions = new PoolOptions().setMaxSize(15);
        // Create the pooled client
        PgPool pgPool = PgPool.pool(vertx, connectOptions, poolOptions);
        return pgPool;
    }

}
