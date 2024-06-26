package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface InspectionSalesService {
    SalesInspectionResponse salesInspectionsListByDate(String startDate, String endDate, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, int page, int limit, String sort);

    ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String noteAdded, MultipartFile[] files, String username);

    ResponseDTO insertSalesAssessment(SalesAssessmentRegisterRequest insertDto, MultipartFile[] files, String username);

    List<SalesAssessmentResponse> getSalesAssessment(Long inspectionId);

    List<QuotationResponse> getQuotation(Long inspectionId);

    ResponseDTO insertQuotation(QuotationInsertRequest insertDto, MultipartFile[] files, String username);

    byte[] exportInspectionsToExcel(String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, String sort);
}
