package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.InspectionCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InspectionCodeRepository extends JpaRepository<InspectionCode,Long> {
    List<InspectionCode> findAllByMeterType(String meterType);
}
