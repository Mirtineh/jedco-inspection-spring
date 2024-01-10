package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;

public record CodeResultResponse(
        Long id,
        Long inspectionCodeId,
        String inspectionCode,
        String description,
        String result,
        Date registeredOn,
        Date updatedOn
) {
}
