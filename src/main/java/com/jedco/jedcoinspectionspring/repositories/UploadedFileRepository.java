package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadedFileRepository extends JpaRepository<UploadedFile,Long> {
}
