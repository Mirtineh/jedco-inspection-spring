package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;

public record UserRoleResponse(
        String id,
        String name,
        String description,
        Date createdOn,
        Date updateOn
) {
}
