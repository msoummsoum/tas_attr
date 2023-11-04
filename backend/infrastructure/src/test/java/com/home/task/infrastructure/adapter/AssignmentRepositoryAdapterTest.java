package com.home.task.infrastructure.adapter;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.infrastructure.repository.AssignmentJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@DataJpaTest
@EnableJpaRepositories(basePackages = {"com.home.task.infrastructure.repository"})
@EntityScan("com.home.task.infrastructure.entity")
public class AssignmentRepositoryAdapterTest {

    @Autowired
    private AssignmentRepositoryAdapter assignmentRepositoryAdapter;

    @Test
    public void test() {
        //Given
        Assignment assignment = new Assignment(1L, "nom", "description", Status.PENDING);

        //When
        Assignment assignmentAdded = assignmentRepositoryAdapter.add(assignment);

        //Then
        Assertions.assertEquals("description", assignmentAdded.description());
    }

    @Configuration
    static class RepositoryTestConfig {
        @Bean
        public AssignmentRepositoryAdapter assignmentRepositoryAdapter(AssignmentJpaRepository assignmentJpaRepository) {
            return new AssignmentRepositoryAdapter(assignmentJpaRepository);
        }
    }
}
