package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record CodeResultResponse(
        Long id,
        Long inspectionCodeId,
        String inspectionCode,
        String description,
        String result,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date registeredOn,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date updatedOn
) {
}
