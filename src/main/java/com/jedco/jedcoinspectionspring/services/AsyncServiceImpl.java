package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.models.TaskHistory;
import com.jedco.jedcoinspectionspring.repositories.TaskHistoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncServiceImpl implements AsyncService {
    private final TaskHistoryRepository taskHistoryRepository;
    @Override
    @Async
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void postHistory(TaskHistory taskHistory) {
        log.info(" inserting task history to db ..................... ");
        try{

            taskHistoryRepository.save(taskHistory);
        }catch (Exception ex){

               log.error("Task History Insert Details => Failed to register due to "+ex.getMessage());

        }
    }
}
