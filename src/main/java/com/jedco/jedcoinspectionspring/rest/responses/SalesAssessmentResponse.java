package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;

public record SalesAssessmentResponse(
        Long id,
        Long inspectionId,
        String registeredBy,
        String txNo,
        Double distance,
        Double northing,
        Double easting,
        Date registeredOn
) {
}
