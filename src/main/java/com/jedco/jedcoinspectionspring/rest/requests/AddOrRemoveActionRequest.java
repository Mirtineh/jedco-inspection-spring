package com.jedco.jedcoinspectionspring.rest.requests;

import java.util.List;

public record AddOrRemoveActionRequest(
        Long userRoleId,
        List<Long> userActions
) {
}
