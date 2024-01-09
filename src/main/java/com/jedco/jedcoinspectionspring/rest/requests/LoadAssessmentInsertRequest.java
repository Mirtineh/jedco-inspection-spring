package com.jedco.jedcoinspectionspring.rest.requests;

import java.util.List;

public record LoadAssessmentInsertRequest(
        String customerType,
        String presentedDocument,
        String reason,
        Long inspectionId,
        List<CustomerLoadInsertRequest> customerLoadInsertDto
) {
}
