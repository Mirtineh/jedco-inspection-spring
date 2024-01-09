package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.UserActionsListByGroupResponse;

import java.security.Principal;
import java.util.List;

public interface UserActionService {
    public List<UserActionsListByGroupResponse> userActionList();
}
