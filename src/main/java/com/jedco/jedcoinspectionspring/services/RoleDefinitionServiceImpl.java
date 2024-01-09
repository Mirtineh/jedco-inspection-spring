package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.AddOrRemoveActionRequest;
import com.jedco.jedcoinspectionspring.rest.requests.RoleDefineRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.RoleDefinitionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleDefinitionServiceImpl implements RoleDefinitionService {
    @Override
    public ResponseDTO defineRole(RoleDefineRequest roleDefineDto) {
        return null;
    }

    @Override
    public ResponseDTO updateDefinedActions(AddOrRemoveActionRequest addOrRemoveActionDto) {
        return null;
    }

    @Override
    public ResponseDTO deleteUserRole(Long userRoleId) {
        return null;
    }

    @Override
    public List<RoleDefinitionResponse> definedRolesList(Long userRoleId) {
        return null;
    }
}
