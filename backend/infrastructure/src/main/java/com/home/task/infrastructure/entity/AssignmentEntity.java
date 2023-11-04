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

    public static AssignmentEntity fromDomainObject(Assignment assignment) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity.setId(assignment.id());
        assignmentEntity.setName(assignment.name());
        assignmentEntity.setDescription(assignment.description());
        assignmentEntity.setStatus(assignment.status());
        return assignmentEntity;
    }

    public Assignment toDomainObject() {
        return new Assignment(this.id, this.name, this.description, this.status);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
