package com.home.task.infrastructure.repository;

import com.home.task.infrastructure.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, Long> {
}
