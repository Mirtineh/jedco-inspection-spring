package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionCodesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.PriorityResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.util.List;

public interface InspectionService {
    ResponseDTO insertInspection(InspectionInsertRequest insertDto, String username);

    List<PriorityResponse> priorityList();

    List<InspectionResponse> inspectionsListByDate(String startDate, String endDate, String username);

    List<InspectionResponse> adminInspectionsListByDate(String startDate, String endDate, String username);

    List<InspectionResponse> getInspectionsByDateAndStatus(String startDate, String endDate, Long statusId);

    List<InspectionCodesResponse> inspectionCodesList(String meterType);

    ResponseDTO sendToSales(Long inspectionId, Long priorityId, String note, String username);

}
