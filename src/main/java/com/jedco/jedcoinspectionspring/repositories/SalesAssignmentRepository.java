package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.SalesAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesAssignmentRepository extends JpaRepository<SalesAssignment,Long> {
    Optional<SalesAssignment> findOneByInspectionId(Long inspectionId);
}
