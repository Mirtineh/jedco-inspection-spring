package com.jedco.jedcoinspectionspring.rest.requests;

public record UserNameAndPasswordRequest(
        String activationNo,
        String userName,
        String Password
) {
}
