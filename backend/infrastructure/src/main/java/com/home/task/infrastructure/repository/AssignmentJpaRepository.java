package com.home.task.infrastructure.repository;

import com.home.task.domain.object.Status;
import com.home.task.infrastructure.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, Long> {
    List<AssignmentEntity> findByStatus(Status status);
}
