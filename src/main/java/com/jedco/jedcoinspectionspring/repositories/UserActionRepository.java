package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActionRepository extends JpaRepository<UserAction,Long> {
}
