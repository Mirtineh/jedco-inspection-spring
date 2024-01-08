package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.InspectionCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionCodeRepository extends JpaRepository<InspectionCode,Long> {
}
