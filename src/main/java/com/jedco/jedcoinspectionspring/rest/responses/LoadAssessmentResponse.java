package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.List;

public record LoadAssessmentResponse(

        Long id,
        String customerType,
        String presentedDocument,
        String reason,
        Long registeredById,
        String registeredBy,
        List<CustomerLoadResponse> customerLoadDtos
) {
}