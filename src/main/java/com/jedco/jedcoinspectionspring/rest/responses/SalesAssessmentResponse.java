package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record SalesAssessmentResponse(
        Long id,
        Long inspectionId,
        String registeredBy,
        String txNo,
        Double distance,
        Double northing,
        Double easting,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date registeredOn
) {
}
