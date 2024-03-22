package com.jedco.jedcoinspectionspring.rest.requests;

public record QuotationInsertRequest(
        Long inspectionId,
        String quotationRef,
        double amount,
        String note
) {
}
