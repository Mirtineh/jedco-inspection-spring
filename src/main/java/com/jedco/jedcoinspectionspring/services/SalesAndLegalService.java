package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.models.Inspection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SalesAndLegalService {
    Page<Inspection> getAllInspectionsData(Long statusId, String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses,String problemType, Pageable pageable);
}
