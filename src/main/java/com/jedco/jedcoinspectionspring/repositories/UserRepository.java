package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    List<User> findAllByUserRole_IdAndStatusId_Not(Long userRoleId, Long deletedStatus);

    List<User> findByUsernameIsNotNullAndUsernameNotAndStatusId_Not(String admin, Long deletedStatus);

    List<User> findByUsernameIsNotNullAndUsernameNotAndUserRole_IdAndStatusId_Not(String admin, Long roleId, Long deletedStatus);

    Optional<User> findByActivationNo(String number);
}
