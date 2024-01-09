package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.List;

public record RoleDefinitionResponse(
        String roleId,
        String roleName,
        List<UserActionResponse> userActionList
) {
}
