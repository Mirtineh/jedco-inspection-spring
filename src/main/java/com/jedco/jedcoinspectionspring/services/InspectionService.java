package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionCodesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.PriorityResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.security.Principal;
import java.util.List;

public interface InspectionService {
    public ResponseDTO insertInspection(InspectionInsertRequest insertDto, String username);
    public List<PriorityResponse> priorityList();
    public List<InspectionResponse> inspectionsListByDate(String startDate, String endDate, String username);
    public List<InspectionResponse> adminInspectionsListByDate(String startDate, String endDate, String username);
    public List<InspectionResponse> getInspectionsByDateAndStatus(String startDate, String endDate, Long statusId);
    public List<InspectionCodesResponse> inspectionCodesList(String meterType);
    public ResponseDTO sendToSales(Long inspectionId, Long priorityId, String note, String username);

}
