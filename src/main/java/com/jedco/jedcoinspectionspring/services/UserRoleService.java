package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.UserRoleUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserRoleResponse;

import java.util.List;

public interface UserRoleService {
    ResponseDTO userRoleUpdate(UserRoleUpdateRequest userRoleUpdateDto);

    List<UserRoleResponse> userRoleList();
}
