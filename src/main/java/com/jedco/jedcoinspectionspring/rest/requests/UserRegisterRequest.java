package com.jedco.jedcoinspectionspring.rest.requests;

public record UserRegisterRequest(
        Long userRoleId,
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        String phone,
        String activationNo
) {
}
