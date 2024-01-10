package com.jedco.jedcoinspectionspring.rest.responses;

public record StatusResponse(
        String id,
        Long statusId,
        String statusName,
        String statusDescription
) {
}
