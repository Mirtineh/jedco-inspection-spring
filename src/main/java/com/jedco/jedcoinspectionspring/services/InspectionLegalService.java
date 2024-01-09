package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.util.List;

public interface InspectionLegalService {
    List<InspectionSalesResponse> legalInspectionsListByDate(String startDate, String endDate);

    ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String note, String username);
}
