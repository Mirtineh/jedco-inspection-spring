package com.jedco.jedcoinspectionspring.rest.responses;

public record ActionResponse(
        String userActionId,
        String action,
        boolean actionStatus
) {
}
