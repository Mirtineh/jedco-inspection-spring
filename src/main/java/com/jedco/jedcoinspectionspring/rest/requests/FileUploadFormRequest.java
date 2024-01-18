package com.jedco.jedcoinspectionspring.rest.requests;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadFormRequest(MultipartFile data, Long inspectionId, String fileName) {
}
