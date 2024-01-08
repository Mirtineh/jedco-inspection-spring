package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
