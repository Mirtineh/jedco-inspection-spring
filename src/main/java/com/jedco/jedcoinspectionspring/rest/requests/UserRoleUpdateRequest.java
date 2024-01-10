package com.jedco.jedcoinspectionspring.rest.requests;

public record UserRoleUpdateRequest(
        Long id,
        String name,
        String description
) {
}
