package com.jedco.jedcoinspectionspring.rest.responses;

public record PersonResponse(
        String id,
        Long statusId,
        String firstName,
        String lastName,
        String phoneNo,
        String email,
        String membershipType,
        String teamName
) {
}
