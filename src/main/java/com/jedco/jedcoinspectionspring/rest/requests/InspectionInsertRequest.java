package com.jedco.jedcoinspectionspring.rest.requests;

import java.util.List;

public record InspectionInsertRequest(
        String problemType,
        String meterType,
        String customerStatus,
        String location,
        String customerName,
        String phoneNumber,
        String meterNumber,
        String ciuNumber,
        String connType,
        String tariffCat,
        String feeder,
        String txNo,
        Double latitude,
        Double longitude,
        Double locationAccuracy,
        String customerSatisfactionReview,
        String remark,
        List<CheckListResultInsertRequest> checkListResultList,
        List<CodeResultInsertRequest> codeResultList
) {
}
