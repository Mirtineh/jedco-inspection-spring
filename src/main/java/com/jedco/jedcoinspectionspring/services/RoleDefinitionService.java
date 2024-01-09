package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.AddOrRemoveActionRequest;
import com.jedco.jedcoinspectionspring.rest.requests.RoleDefineRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.RoleDefinitionResponse;

import java.security.Principal;
import java.util.List;

public interface RoleDefinitionService {
    public ResponseDTO defineRole(RoleDefineRequest roleDefineDto);
    public ResponseDTO updateDefinedActions(AddOrRemoveActionRequest addOrRemoveActionDto);
    public ResponseDTO deleteUserRole(Long userRoleId);
    public List<RoleDefinitionResponse> definedRolesList(Long userRoleId);
}
