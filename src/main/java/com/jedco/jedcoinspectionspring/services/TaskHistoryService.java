package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskHistoryService {
    List<TaskHistoryResponse> getTaskHistory(Long taskId);

    ResponseEntity<Resource> downloadFile(Long fileId);
}
