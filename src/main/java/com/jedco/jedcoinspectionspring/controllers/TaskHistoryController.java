package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import com.jedco.jedcoinspectionspring.services.TaskHistoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taskHistory")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "TaskHistory")
public class TaskHistoryController {
    private final TaskHistoryService taskHistoryService;

    @GetMapping("/getTaskHistory")
    public List<TaskHistoryResponse> getTaskHistory(@RequestParam("typeId") Long typeId) {
        return this.taskHistoryService.getTaskHistory(typeId);
    }
}
