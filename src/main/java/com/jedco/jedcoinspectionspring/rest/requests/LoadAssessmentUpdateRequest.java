package com.jedco.jedcoinspectionspring.rest.requests;

import java.util.List;

public record LoadAssessmentUpdateRequest(
        Long id,
        String customerType,
        String presentedDocument,
        String reason,
        List<CustomerLoadUpdateRequest> customerLoadUpdateRequestList
) {
}
