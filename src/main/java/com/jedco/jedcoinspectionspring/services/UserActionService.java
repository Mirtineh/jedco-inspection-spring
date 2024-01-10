package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.UserActionsListByGroupResponse;

import java.util.List;

public interface UserActionService {
    List<UserActionsListByGroupResponse> userActionList();
}
