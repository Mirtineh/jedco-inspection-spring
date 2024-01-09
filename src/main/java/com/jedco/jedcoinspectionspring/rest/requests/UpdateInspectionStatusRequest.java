package com.jedco.jedcoinspectionspring.rest.requests;

public record UpdateInspectionStatusRequest(
        Long inspectionId,
        Long statusId,
        String note
) {
}
