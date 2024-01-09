package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.QuotationResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesAssessmentResponse;

import java.security.Principal;
import java.util.List;

public interface InspectionSalesService {
    public List<InspectionSalesResponse> salesInspectionsListByDate(String startDate, String endDate);
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String noteAdded, String username);
    public ResponseDTO insertSalesAssessment(SalesAssessmentRegisterRequest insertDto, String username);
    public List<SalesAssessmentResponse> getSalesAssessment(Long inspectionId);
    public List<QuotationResponse> getQuotation(Long inspectionId);
    public ResponseDTO insertQuotation(QuotationInsertRequest insertDto, String username);

}
