package com.home.task.domain.port;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;

import java.util.List;

public interface AssignmentRepository {
    public Assignment add(Assignment assignment);

    public List<Assignment> getAllByStatus(Status status);
}
