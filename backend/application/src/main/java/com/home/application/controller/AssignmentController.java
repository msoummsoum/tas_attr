package com.home.application.controller;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import com.home.task.domain.usecase.CreateAssignment;
import com.home.task.domain.usecase.GetAllAssignmentByStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    private CreateAssignment createAssignment;
    @Autowired
    private GetAllAssignmentByStatus getAllAssignmentByStatus;

    /*public AssignmentController(CreateAssignment createAssignment, GetAllAssignmentByStatus getAllAssignmentByStatus) {
        this.createAssignment = createAssignment;
        this.getAllAssignmentByStatus = getAllAssignmentByStatus;
    }*/

    @PostMapping
    public ResponseEntity<Assignment> create(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(createAssignment.execute(assignment), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAllByStatus(@RequestParam("status") Status status) {
        return new ResponseEntity<>(getAllAssignmentByStatus.execute(status), HttpStatus.OK);
    }
}
