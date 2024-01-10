package com.jedco.jedcoinspectionspring.rest.requests;

public record UpdateUserRoleRequest(
        Long userId,
        Long userRoleId
) {
}
