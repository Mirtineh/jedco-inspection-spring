package com.jedco.jedcoinspectionspring.rest.responses;

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
        Date createdOn,
        Date updatedOn,
        Long statusId,
        String statusName,
        String activationNo
) {
}
