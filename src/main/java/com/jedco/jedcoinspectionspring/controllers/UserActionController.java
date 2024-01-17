package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.responses.UserActionsListByGroupResponse;
import com.jedco.jedcoinspectionspring.services.UserActionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserAction")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "UserManagement")
public class UserActionController {
    private final UserActionService userActionService;

    @GetMapping("/userActionList")
    @PreAuthorize("hasAnyAuthority('VIEW_ROLE')")
    public List<UserActionsListByGroupResponse> userActionList(@RequestParam(value = "startPosition", required = false) Integer startPosition, @RequestParam(value = "maxPosition", required = false) Integer maxPosition) {
        return this.userActionService.userActionList();
    }
}
