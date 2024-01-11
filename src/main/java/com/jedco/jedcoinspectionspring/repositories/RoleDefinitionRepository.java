package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.RoleDefinition;
import com.jedco.jedcoinspectionspring.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDefinitionRepository extends JpaRepository<RoleDefinition,Long> {
    List<RoleDefinition> findByUserRole(UserRole userRole);
}
