package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.TaskHistoryMapper;
import com.jedco.jedcoinspectionspring.models.TaskHistory;
import com.jedco.jedcoinspectionspring.repositories.TaskHistoryRepository;
import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskHistoryServiceImpl implements TaskHistoryService {
    private final TaskHistoryRepository taskHistoryRepository;
    private final TaskHistoryMapper taskHistoryMapper;
    @Override
    public List<TaskHistoryResponse> getTaskHistory(Long taskId) {
        List<TaskHistory> taskHistoryList= taskHistoryRepository.findAllByInspection_Id(taskId);
        return taskHistoryList.stream().map(taskHistoryMapper::toResponse).toList();
    }
}
