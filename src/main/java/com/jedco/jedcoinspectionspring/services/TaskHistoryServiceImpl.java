package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.TaskHistoryMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.TaskHistoryRepository;
import com.jedco.jedcoinspectionspring.repositories.UploadedFileRepository;
import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskHistoryServiceImpl implements TaskHistoryService {
    private final TaskHistoryRepository taskHistoryRepository;
    private final UploadedFileRepository uploadedFileRepository;
    private final TaskHistoryMapper taskHistoryMapper;
    private final AsyncService asyncService;
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Override
    public List<TaskHistoryResponse> getTaskHistory(Long taskId) {
        List<TaskHistory> taskHistoryList= taskHistoryRepository.findAllByInspection_Id(taskId);
        return taskHistoryList.stream().map(taskHistoryMapper::toResponse).toList();
    }

    @Override
    public ResponseEntity<Resource> downloadFile(Long fileId) {
        Optional<UploadedFile> optionalUploadedFile= uploadedFileRepository.findById(fileId);
        if (optionalUploadedFile.isEmpty()) {
            throw new RuntimeException("File not found with ID: " + fileId);
        }
        UploadedFile uploadedFile = optionalUploadedFile.get();
        String fileName = uploadedFile.getName();
        String filePath = uploadedFile.getPath();
        String path= uploadDir+ File.separator+filePath;
        Path file = Paths.get(path);
        Resource resource;
        try {
            resource = new UrlResource(file.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }

        // Try to determine file's content type
        String contentType;
        try {
            contentType = Files.probeContentType(file);
        } catch (IOException e) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + uploadedFile.getName() + "\"")
                .body(resource);
    }

    @Override
    public void insertTaskHistory(Inspection inspection, String note, User user, String actionType, String detailInfo, String fileSeparator, MultipartFile[] files) {
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setActionDate(new Date());
        taskHistory.setAdditionalNote(note);
        taskHistory.setInspection(inspection);
        taskHistory.setActionBy(user);
        taskHistory.setActionType(actionType);
        taskHistory.setHistoryDetails(detailInfo);
        List<UploadedFile> uploadedFileList=new ArrayList<>();
        if (files != null) {
            String folder = uploadDir;
            String path = File.separator+fileSeparator+File.separator+inspection.getId()+File.separator;
            folder+=path;
            File directory = new File(folder);

            if (!directory.exists()) {
                directory.mkdirs(); // Create directory if it doesn't exist
            }
            for (MultipartFile file : files) {
                try {
                    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    Path filePath = Paths.get(folder + fileName);
                    Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    UploadedFile uploadedFile = new UploadedFile();
                    uploadedFile.setName(file.getOriginalFilename());
                    uploadedFile.setPath(path+fileName);
                    uploadedFile.setTaskHistory(taskHistory);
                    uploadedFile.setUploadedOn(new Date());
                    uploadedFile.setUploadedBy(user);
                    uploadedFile.setTaskHistory(taskHistory);
                    uploadedFileList.add(uploadedFile);
                } catch (Exception e) {
                    log.error(e.getMessage());
//                    e.printStackTrace();
                    // Handle file saving exception
                }

            }
            taskHistory.setUploadedFiles(uploadedFileList);
        }

        this.asyncService.postHistory(taskHistory);
    }
}
