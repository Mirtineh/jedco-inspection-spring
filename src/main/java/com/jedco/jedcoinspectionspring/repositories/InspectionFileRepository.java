package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.InspectionFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionFileRepository extends JpaRepository<InspectionFile,Long> {
}
