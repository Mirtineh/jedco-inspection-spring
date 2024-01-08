package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.InspectionAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionAssessmentRepository extends JpaRepository<InspectionAssessment,Long> {
}
