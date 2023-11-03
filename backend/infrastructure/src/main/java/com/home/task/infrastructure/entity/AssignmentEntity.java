package com.home.task.infrastructure.entity;

import com.home.task.domain.object.Assignment;
import com.home.task.domain.object.Status;
import jakarta.persistence.*;


@Entity
@Table(name = "assignment")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Status status;

    public AssignmentEntity() {
    }

    public AssignmentEntity(Long id, String name, String description, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public static AssignmentEntity fromDomainObject(Assignment assignment) {
        return new AssignmentEntity(assignment.id(), assignment.name(), assignment.description(), assignment.status());
    }

    public Assignment toDomainObject() {
        return new Assignment(this.id, this.name, this.description, this.status);
    }
}
