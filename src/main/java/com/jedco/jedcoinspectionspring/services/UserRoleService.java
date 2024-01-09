package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.UserRoleUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserRoleResponse;

import java.security.Principal;
import java.util.List;

public interface UserRoleService {
    public ResponseDTO userRoleUpdate(UserRoleUpdateRequest userRoleUpdateDto);
    public List<UserRoleResponse> userRoleList();
}
