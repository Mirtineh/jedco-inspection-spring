package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.SalesAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesAssessmentRepository extends JpaRepository<SalesAssessment,Long> {
    List<SalesAssessment> findAllByInspection_Id(Long inspectionId);
}
