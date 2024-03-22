package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.models.Inspection;
import com.jedco.jedcoinspectionspring.models.Status;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TaskHistoryService {
    List<TaskHistoryResponse> getTaskHistory(Long taskId);

    ResponseEntity<Resource> downloadFile(Long fileId);

    void insertTaskHistory(Inspection inspection,String note, User user, String actionType, String detailInfo, String fileSeparator, MultipartFile[] files);
}
