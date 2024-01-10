package com.jedco.jedcoinspectionspring.rest.requests;

public record CodeResultInsertRequest(
        Long inspectionCodeId,
        String result
) {
}
