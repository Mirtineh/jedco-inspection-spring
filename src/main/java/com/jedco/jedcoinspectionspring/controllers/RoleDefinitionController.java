package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.AddOrRemoveActionRequest;
import com.jedco.jedcoinspectionspring.rest.requests.RoleDefineRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.RoleDefinitionResponse;
import com.jedco.jedcoinspectionspring.services.RoleDefinitionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleDefinition")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "RoleDefinition")
public class RoleDefinitionController {
    private final RoleDefinitionService roleDefinitionService;

    @PostMapping("/defineRole")
    @PreAuthorize("hasAnyAuthority('CREATE_ROLE')")
    public ResponseDTO defineRole(@RequestBody RoleDefineRequest entity) {
        return roleDefinitionService.defineRole(entity);
    }

    @PutMapping("/updateDefinedActions")
    @PreAuthorize("hasAnyAuthority('UPDATE_ROLE')")
    public ResponseDTO updateDefinedActions(@RequestBody AddOrRemoveActionRequest entity) {
        return this.roleDefinitionService.updateDefinedActions(entity);
    }

    @DeleteMapping("/deleteUserRole")
    @PreAuthorize("hasAnyAuthority('DELETE_ROLE')")
    public ResponseDTO deleteUserRole(@RequestParam("UserRoleID") Long id) {
        return roleDefinitionService.deleteUserRole(id);
    }

    @GetMapping("/definedRolesList")
    @PreAuthorize("hasAnyAuthority('VIEW_ROLE')")
    public List<RoleDefinitionResponse> definedRolesList(@RequestParam("userRoleId") Long userRoleId, @RequestParam(value = "startPosition", required = false) int startPosition, @RequestParam(value = "maxPosition", required = false) int maxPosition) {
        return this.roleDefinitionService.definedRolesList(userRoleId);
    }
}
