package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record UserResponse(
        Long userId,
        Long userRoleId,
        String userRoleName,
        String firstName,
        String lastName,
        String email,
        String phone,
        String userName,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date createdOn,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date updatedOn,
        Long statusId,
        String statusName,
        String activationNo
) {
}
