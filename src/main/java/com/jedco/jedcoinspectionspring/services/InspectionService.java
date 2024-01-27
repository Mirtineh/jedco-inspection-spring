package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.FileUploadFormRequest;
import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.*;

import java.util.List;

public interface InspectionService {
    ResponseDTO insertInspection(InspectionInsertRequest insertDto, String username);

    List<PriorityResponse> priorityList();

    List<InspectionResponse> inspectionsListByDate(String startDate, String endDate, String username);

    AdminInspectionResponse adminInspectionsListByDate(String startDate, String endDate,String customerName,String meterNumber,List<Long> statuses, int page, int limit,String sort);
    public byte[] exportInspectionsToExcel(String startDateString, String endDateString, String customerName, String meterNumber, List<Long> statuses, String sort);

    List<InspectionResponse> getInspectionsByDateAndStatus(String startDate, String endDate, Long statusId);

    List<InspectionCodesResponse> inspectionCodesList(String meterType);

    ResponseDTO sendToSales(Long inspectionId, Long priorityId, String note, String username);

    ResponseDTO upload(FileUploadFormRequest form, String username);

}
