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

import java.util.List;

@DataJpaTest
@EnableJpaRepositories(basePackages = {"com.home.task.infrastructure.repository"})
@EntityScan("com.home.task.infrastructure.entity")
public class AssignmentRepositoryAdapterTest {

    @Autowired
    private AssignmentRepositoryAdapter assignmentRepositoryAdapter;

    @Test
    public void should_save_assignment() {
        //Given
        Assignment assignment = new Assignment(null, "nom", "description", Status.PENDING);

        //When
        Assignment assignmentAdded = assignmentRepositoryAdapter.add(assignment);

        //Then
        Assertions.assertNotNull(assignmentAdded.id());
        Assertions.assertEquals(assignment.name(), assignmentAdded.name());
        Assertions.assertEquals(assignment.description(), assignmentAdded.description());
        Assertions.assertEquals(assignment.status(), assignmentAdded.status());
    }

    @Test
    public void should_get_all_assignments_having_given_status() {
        //Given
        Assignment assignment1 = new Assignment(null, "nom1", "description1", Status.PENDING);
        Assignment assignment2 = new Assignment(null, "nom2", "description2", Status.COMPLETED);
        Assignment assignment3 = new Assignment(null, "nom3", "description3", Status.PENDING);
        assignmentRepositoryAdapter.add(assignment1);
        assignmentRepositoryAdapter.add(assignment2);
        assignmentRepositoryAdapter.add(assignment3);

        //When
        List<Assignment> assignmentList = assignmentRepositoryAdapter.getAllByStatus(Status.PENDING);

        //Given
        Assertions.assertEquals(2, assignmentList.size());
    }

    @Test
    public void should_get_empty_list_having_given_status() {
        //Given
        Assignment assignment1 = new Assignment(null, "nom1", "description1", Status.PENDING);
        Assignment assignment2 = new Assignment(null, "nom2", "description2", Status.COMPLETED);
        Assignment assignment3 = new Assignment(null, "nom3", "description3", Status.PENDING);
        assignmentRepositoryAdapter.add(assignment1);
        assignmentRepositoryAdapter.add(assignment2);
        assignmentRepositoryAdapter.add(assignment3);

        //When
        List<Assignment> assignmentList = assignmentRepositoryAdapter.getAllByStatus(Status.ABANDONED);

        //Given
        Assertions.assertEquals(0, assignmentList.size());
    }

    @Configuration
    static class RepositoryTestConfig {
        @Bean
        public AssignmentRepositoryAdapter assignmentRepositoryAdapter(AssignmentJpaRepository assignmentJpaRepository) {
            return new AssignmentRepositoryAdapter(assignmentJpaRepository);
        }
    }
}
