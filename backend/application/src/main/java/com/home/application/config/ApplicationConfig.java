package com.home.application.config;

import com.home.task.domain.port.AssignmentRepository;
import com.home.task.domain.usecase.CreateAssignment;
import com.home.task.domain.usecase.GetAllAssignmentByStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreateAssignment createAssignment(AssignmentRepository assignmentRepository) {
        return new CreateAssignment(assignmentRepository);
    }

    @Bean
    public GetAllAssignmentByStatus getAllAssignmentByStatus(AssignmentRepository assignmentRepository) {
        return new GetAllAssignmentByStatus(assignmentRepository);
    }
}
