package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.security.Principal;
import java.util.List;

public interface InspectionLegalService {
    public List<InspectionSalesResponse> legalInspectionsListByDate(String startDate, String endDate);
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String note, String username);
}
