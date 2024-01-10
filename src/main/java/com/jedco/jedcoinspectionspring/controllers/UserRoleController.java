package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.UserRoleUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserRoleResponse;
import com.jedco.jedcoinspectionspring.services.UserRoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserRole")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "UserManagement")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PutMapping("/updateUserRole")
    @PreAuthorize("hasAnyAuthority('UPDATE_ROLE')")
    public ResponseDTO updateUserRole(@RequestBody UserRoleUpdateRequest entity) {
        return userRoleService.userRoleUpdate(entity);
    }

    @GetMapping("/userRoleList")
    @PreAuthorize("hasAnyAuthority('VIEW_ROLE')")
    public List<UserRoleResponse> userRoleList() {
        return userRoleService.userRoleList();
    }
}
