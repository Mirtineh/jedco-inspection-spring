package com.jedco.jedcoinspectionspring.rest.requests;

public record UseNameAndPasswordRequest(
        String activationNo,
        String userName,
        String Password
) {
}
