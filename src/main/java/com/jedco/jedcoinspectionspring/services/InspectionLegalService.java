package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesInspectionResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InspectionLegalService {
    SalesInspectionResponse legalInspectionsListByDate(String startDate, String endDate,String customerName,String meterNumber,List<Long> statuses, int page, int limit,String sort);

    ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String note, String legalCaseNo, MultipartFile[] files, String username);

    byte[] exportInspectionsToExcel(String startDateString, String endDateString, String customerName, String meterNumber, List<Long> statuses, String sort);
}
