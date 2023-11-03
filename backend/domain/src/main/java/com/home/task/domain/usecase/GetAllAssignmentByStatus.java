package com.home.task.domain.usecase;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.port.AssignmentRepository;

import java.util.List;

public class GetAllAssignmentByStatus {

    private AssignmentRepository assignmentRepository;

    public GetAllAssignmentByStatus(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    List<Assignment> execute(Status status) {
        return this.assignmentRepository.getAllByStatus(status);
    }
}
