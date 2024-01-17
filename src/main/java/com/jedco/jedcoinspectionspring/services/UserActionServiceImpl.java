package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.UserMapper;
import com.jedco.jedcoinspectionspring.models.ActionGroup;
import com.jedco.jedcoinspectionspring.repositories.ActionGroupRepository;
import com.jedco.jedcoinspectionspring.rest.responses.UserActionsListByGroupResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserActionServiceImpl implements UserActionService {
    private final ActionGroupRepository actionGroupRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserActionsListByGroupResponse> userActionList() {
        List<ActionGroup> actionGroups = actionGroupRepository.findAll();
        return actionGroups.stream().map(userMapper::toUserAction).toList();
    }
}
