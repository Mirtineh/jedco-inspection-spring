package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;

import java.util.List;

public interface TaskHistoryService {
    List<TaskHistoryResponse> getTaskHistory(Long taskId);
}