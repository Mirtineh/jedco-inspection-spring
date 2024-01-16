package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.RoleDefinition;
import com.jedco.jedcoinspectionspring.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleDefinitionRepository extends JpaRepository<RoleDefinition,Long> {
    List<RoleDefinition> findByUserRole(UserRole userRole);


    List<RoleDefinition> findAllByUserRoleId(Long id);

    Optional<RoleDefinition> findOneByUserAction_IdAndUserRole_Id(Long userActionId, Long id);

    List<RoleDefinition> findAllByUserRoleIdAndStatus_Id(Long userRoleId, long l);
}
