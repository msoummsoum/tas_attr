package com.home.task.infrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.home.task.infrastructure.repository"})
@EntityScan("com.home.task.infrastructure.entity")
@Configuration
public class InfraConfig {
}
