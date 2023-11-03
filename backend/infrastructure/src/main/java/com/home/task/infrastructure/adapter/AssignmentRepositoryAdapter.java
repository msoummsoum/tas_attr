package com.home.task.infrastructure.adapter;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.port.AssignmentRepository;
import com.home.task.infrastructure.entity.AssignmentEntity;
import com.home.task.infrastructure.repository.AssignmentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class AssignmentRepositoryAdapter implements AssignmentRepository {

    private AssignmentJpaRepository assignmentJpaRepository;

    @Autowired
    public AssignmentRepositoryAdapter(AssignmentJpaRepository assignmentJpaRepository) {
        this.assignmentJpaRepository = assignmentJpaRepository;
    }

    @Override
    public Assignment add(Assignment assignment) {
        var a = new AssignmentEntity();
        a.setDescription("yes");
        a.setName("noooo");
        a.setStatus(Status.PENDING);
        assignmentJpaRepository.save(a);
        return null;
    }

    @Override
    public List<Assignment> getAllByStatus(Status status) {
        return null;
    }
}
