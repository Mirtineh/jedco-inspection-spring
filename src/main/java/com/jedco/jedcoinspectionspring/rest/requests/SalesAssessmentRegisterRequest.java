package com.jedco.jedcoinspectionspring.rest.requests;

public record SalesAssessmentRegisterRequest(
        Long inspectionId,
        String txNo,
        Double distance,
        Double northing,
        Double easting,
        String note
) {
}
