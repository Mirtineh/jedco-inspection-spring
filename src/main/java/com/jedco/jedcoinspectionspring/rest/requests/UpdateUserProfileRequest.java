package com.jedco.jedcoinspectionspring.rest.requests;

public record UpdateUserProfileRequest(
        Long userId,
        Long userRoleId,
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
