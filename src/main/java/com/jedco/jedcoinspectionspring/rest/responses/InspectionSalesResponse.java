package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;
import java.util.List;

public record InspectionSalesResponse(
        Long id,
        String problemType,
        String meterType,
        String location,
        Long statusId,
        String status,
        String customerName,
        String phoneNumber,
        String metterNumber,
        String ciuNumber,
        String connType,
        String tarifCat,
        Date registeredDate,
        String feeder,
        String txNo,
        String registeredBy,
        String priorityLevel,
        String assignmentNote,
        Date sentToSalesOn,
        List<CheckListResultResponse> checkListResultList,
        List<CodeResultResponse> codeResultList,
        String filePath,
        boolean assesmentSubmitted,
        String customerStatus
) {
}
