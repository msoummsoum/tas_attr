package com.home.task.domain.usecase;

import com.home.task.domain.documentation.UseCase;
import com.home.task.domain.exception.InvalidDataAssignmentException;
import com.home.task.domain.object.Assignment;
import com.home.task.domain.port.AssignmentRepository;

@UseCase(description = "Create an assignment")
public class CreateAssignment {

    static final String ERROR_MESSAGE_INVALID_DATA = "Name must have at leat 3 caracteres, status must be filled";
    private AssignmentRepository assignmentRepository;

    public CreateAssignment(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment execute(Assignment assignment) {
        if (assignment != null && assignment.name() != null && assignment.name().length() < 3) {
            throw new InvalidDataAssignmentException(ERROR_MESSAGE_INVALID_DATA);
        }
        if (assignment.status() == null) {
            throw new InvalidDataAssignmentException(ERROR_MESSAGE_INVALID_DATA);
        }
        return this.assignmentRepository.add(assignment);
    }
}
