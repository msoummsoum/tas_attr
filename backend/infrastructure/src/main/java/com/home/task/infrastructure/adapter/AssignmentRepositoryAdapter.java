package com.home.task.infrastructure.adapter;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.port.AssignmentRepository;
import com.home.task.infrastructure.entity.AssignmentEntity;
import com.home.task.infrastructure.repository.AssignmentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class AssignmentRepositoryAdapter implements AssignmentRepository {

    private AssignmentJpaRepository assignmentJpaRepository;

    @Autowired
    public AssignmentRepositoryAdapter(AssignmentJpaRepository assignmentJpaRepository) {
        this.assignmentJpaRepository = assignmentJpaRepository;
    }

    @Override
    public Assignment add(Assignment assignment) {
        var assignmentEntity = assignmentJpaRepository.save(AssignmentEntity.fromDomainObject(assignment));
        return assignmentEntity.toDomainObject();
    }

    @Override
    public List<Assignment> getAllByStatus(Status status) {
        return assignmentJpaRepository.findByStatus(status).stream().map(AssignmentEntity::toDomainObject).collect(toList());
    }
}
