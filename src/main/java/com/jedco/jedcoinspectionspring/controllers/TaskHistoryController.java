package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import com.jedco.jedcoinspectionspring.services.TaskHistoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

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

    @GetMapping("/download/{fileId:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        return this.taskHistoryService.downloadFile(fileId);
    }
}
