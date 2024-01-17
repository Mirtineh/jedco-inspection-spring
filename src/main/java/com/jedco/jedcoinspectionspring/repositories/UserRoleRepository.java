package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    Optional<UserRole> findByRoleName(String s);

    Optional<UserRole> findOneByIdAndStatus_Id(Long aLong, long l);
}
