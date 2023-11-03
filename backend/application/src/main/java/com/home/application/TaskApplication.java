package com.home.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.home")
public class TaskApplication {
    public static void main(String... args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
