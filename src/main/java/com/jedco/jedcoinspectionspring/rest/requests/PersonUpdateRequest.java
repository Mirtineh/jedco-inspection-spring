package com.jedco.jedcoinspectionspring.rest.requests;

public record PersonUpdateRequest(
        Long id,
        String firstName,
        String lastName,
        String phoneNo,
        String email
) {
}
