package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.models.TaskHistory;

public interface AsyncService {
    void postHistory(TaskHistory taskHistory);
}
