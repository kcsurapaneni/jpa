package com.learn.jpa;

import org.springframework.boot.test.context.*;
import org.springframework.boot.testcontainers.service.connection.*;
import org.springframework.context.annotation.*;
import org.testcontainers.containers.*;
import org.testcontainers.utility.*;

/**
 * @author Krishna Chaitanya
 */
@TestConfiguration(proxyBeanMethods = false)
public class MyContainersConfiguration {

    @Bean
    @ServiceConnection
    public MySQLContainer<?> mySQLContainer() {
        return new MySQLContainer<>("mysql:8.0.23")
                .withCopyFileToContainer(
                        MountableFile.forClasspathResource("db/init_db.sql"),
                        "/docker-entrypoint-initdb.d/init_db.sql"
                );
    }

}
