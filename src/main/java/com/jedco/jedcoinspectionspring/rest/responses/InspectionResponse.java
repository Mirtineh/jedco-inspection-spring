package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;
import java.util.List;

public record InspectionResponse(
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
        Date completedDate,
        Date approvedDate,
        String feeder,
        String txNo,
        Double latitude,
        Double longitude,
        String registeredBy,
        String customerSatisfactionReview,
        String remark,
        List<CheckListResultResponse> checkListResultList,
        List<CodeResultResponse> codeResultList,
        String filePath,
        boolean assesmentSubmitted,
        String customerStatus
) {
}