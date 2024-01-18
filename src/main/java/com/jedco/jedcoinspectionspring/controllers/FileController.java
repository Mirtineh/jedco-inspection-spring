package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.configuration.FileStorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/inspectionFiles")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Get Lab File")
public class FileController {

    private final FileStorageService fileStorageService;

    @GetMapping("/{folder}/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String folder,
                                              @PathVariable String filename) {
        String relativeUrl = String.format("%s/%s/%s", "inspectionFiles", folder, filename);
        Resource file = fileStorageService.loadFileAsResource(relativeUrl);

        if (file != null) {
            try {
                // Determine the content type dynamically based on the file extension
                String contentType = Files.probeContentType(file.getFile().toPath());

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType)
                        .body(file);
            } catch (IOException e) {
                log.error("File Error: ",e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } else {
            // Handle file not found
            return ResponseEntity.notFound().build();
        }
    }
}
