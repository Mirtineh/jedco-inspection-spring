package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record QuotationResponse(
        Long id,
        Long inspectionId,
        String registeredBy,
        String quotationRef,
        double amount,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date registeredOn
) {
}
