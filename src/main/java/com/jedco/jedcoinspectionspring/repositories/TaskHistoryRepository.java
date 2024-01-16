package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory,Long> {
    List<TaskHistory> findAllByInspection_Id(Long taskId);
}
