package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;

public record QuotationResponse(
        Long id,
        Long inspectionId,
        String registeredBy,
        String quotationRef,
        double amount,
        Date registeredOn
) {
}
