package com.jedco.jedcoinspectionspring.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public Resource loadFileAsResource(String relativeUrl) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(relativeUrl).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                // Handle file not found
                return null;
            }
        } catch (MalformedURLException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    // rest of the class...
}
