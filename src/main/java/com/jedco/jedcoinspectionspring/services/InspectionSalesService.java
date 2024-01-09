package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.QuotationResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesAssessmentResponse;

import java.util.List;

public interface InspectionSalesService {
    List<InspectionSalesResponse> salesInspectionsListByDate(String startDate, String endDate);

    ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String noteAdded, String username);

    ResponseDTO insertSalesAssessment(SalesAssessmentRegisterRequest insertDto, String username);

    List<SalesAssessmentResponse> getSalesAssessment(Long inspectionId);

    List<QuotationResponse> getQuotation(Long inspectionId);

    ResponseDTO insertQuotation(QuotationInsertRequest insertDto, String username);

}
