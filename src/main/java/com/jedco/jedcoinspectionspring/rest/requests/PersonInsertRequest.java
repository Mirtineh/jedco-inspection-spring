package com.jedco.jedcoinspectionspring.rest.requests;

public record PersonInsertRequest(
        String firstName,
        String lastName,
        String phoneNo,
        String email
) {
}
