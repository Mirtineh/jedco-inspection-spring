package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory,Long> {
}
