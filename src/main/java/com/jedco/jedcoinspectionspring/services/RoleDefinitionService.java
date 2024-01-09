package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.AddOrRemoveActionRequest;
import com.jedco.jedcoinspectionspring.rest.requests.RoleDefineRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.RoleDefinitionResponse;

import java.util.List;

public interface RoleDefinitionService {
    ResponseDTO defineRole(RoleDefineRequest roleDefineDto);

    ResponseDTO updateDefinedActions(AddOrRemoveActionRequest addOrRemoveActionDto);

    ResponseDTO deleteUserRole(Long userRoleId);

    List<RoleDefinitionResponse> definedRolesList(Long userRoleId);
}
