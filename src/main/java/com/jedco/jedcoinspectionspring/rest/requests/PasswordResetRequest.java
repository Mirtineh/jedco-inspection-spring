package com.jedco.jedcoinspectionspring.rest.requests;

public record PasswordResetRequest(
        Long userId,
        String password,
        String confirmPassword
) {
}
