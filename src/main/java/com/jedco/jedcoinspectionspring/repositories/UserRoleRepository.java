package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
