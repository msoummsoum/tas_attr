package com.home.application.controller;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.usecase.CreateAssignment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("assignments/")
public class AssignmentController {

    private CreateAssignment createAssignment;

    public AssignmentController(CreateAssignment createAssignment) {
        this.createAssignment = createAssignment;
    }

    @PostMapping
    public ResponseEntity<Assignment> create(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(createAssignment.execute(assignment), HttpStatus.CREATED);
    }
}
