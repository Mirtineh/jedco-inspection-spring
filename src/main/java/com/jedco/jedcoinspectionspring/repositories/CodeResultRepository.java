package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.CodeResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeResultRepository extends JpaRepository<CodeResult,Long> {
}
