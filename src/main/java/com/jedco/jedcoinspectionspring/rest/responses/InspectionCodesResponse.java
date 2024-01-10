package com.jedco.jedcoinspectionspring.rest.responses;

public record InspectionCodesResponse(
        Long id,
        String meterType,
        String code,
        String description
) {
}
