package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record UserRoleResponse(
        String id,
        String name,
        String description,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date createdOn,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date updateOn
) {
}
