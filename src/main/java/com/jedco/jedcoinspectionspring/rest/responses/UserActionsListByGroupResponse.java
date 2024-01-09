package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.List;

public record UserActionsListByGroupResponse(
        Long groupId,
        String groupName,
        String groupDescription,
        List<ActionResponse> actionsDtos
) {
}
