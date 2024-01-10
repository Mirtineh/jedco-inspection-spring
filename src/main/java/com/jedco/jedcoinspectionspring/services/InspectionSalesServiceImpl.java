package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.QuotationResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesAssessmentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionSalesServiceImpl implements InspectionSalesService {
    @Override
    public List<InspectionSalesResponse> salesInspectionsListByDate(String startDate, String endDate) {
        return null;
    }

    @Override
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String noteAdded, String username) {
        return null;
    }

    @Override
    public ResponseDTO insertSalesAssessment(SalesAssessmentRegisterRequest insertDto, String username) {
        return null;
    }

    @Override
    public List<SalesAssessmentResponse> getSalesAssessment(Long inspectionId) {
        return null;
    }

    @Override
    public List<QuotationResponse> getQuotation(Long inspectionId) {
        return null;
    }

    @Override
    public ResponseDTO insertQuotation(QuotationInsertRequest insertDto, String username) {
        return null;
    }
}
