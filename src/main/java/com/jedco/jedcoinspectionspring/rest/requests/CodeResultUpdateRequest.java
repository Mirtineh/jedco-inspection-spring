package com.jedco.jedcoinspectionspring.rest.requests;

public record CodeResultUpdateRequest(
        Long inspectionCodeId,
        Long id,
        String result
) {
}
