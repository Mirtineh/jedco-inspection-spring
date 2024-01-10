package com.jedco.jedcoinspectionspring.rest.requests;

import java.util.List;

public record RoleDefineRequest(
        String userRoleName,
        String userRoleDescription,
        List<Long> userActions
) {
}
