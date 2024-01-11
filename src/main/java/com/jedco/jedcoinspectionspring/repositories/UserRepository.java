package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
