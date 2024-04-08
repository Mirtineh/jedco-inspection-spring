package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

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
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date registeredDate,
        String feeder,
        String txNo,
        String registeredBy,
        String priorityLevel,
        String assignmentNote,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date sentToSalesOn,
        List<CheckListResultResponse> checkListResultList,
        List<CodeResultResponse> codeResultList,
        List<String> filePath,
        boolean assesmentSubmitted,
        String customerStatus,
        String legalCaseNo
) {
}
