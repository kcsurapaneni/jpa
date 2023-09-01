package com.learn.jpa;

import org.junit.jupiter.api.*;
import org.springframework.boot.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
class JpaApplicationTests {

    @Test
    void contextLoads() {
    }

    // Testcontainers at development time - Refer to the following article for more details
    // https://spring.io/blog/2023/06/23/improved-testcontainers-support-in-spring-boot-3-1

    public static void main(String[] args) {
        SpringApplication.from(JpaApplication::main).with(MyContainersConfiguration.class).run(args);
    }

}
