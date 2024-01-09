package com.jedco.jedcoinspectionspring.rest.responses;

public record UserActionResponse(
        String id,
        String action,
        Long groupId,
        String groupName
) {
}
