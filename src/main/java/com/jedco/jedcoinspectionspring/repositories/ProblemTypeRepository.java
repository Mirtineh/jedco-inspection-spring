package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.ProblemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemTypeRepository extends JpaRepository<ProblemType,Long> {
}
