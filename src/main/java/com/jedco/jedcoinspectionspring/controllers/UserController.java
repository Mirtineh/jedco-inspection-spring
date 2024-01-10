package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.*;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserResponse;
import com.jedco.jedcoinspectionspring.services.UserManagementService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "UserManagement")
public class UserController {
    private final UserManagementService userManagementService;

    @PostMapping("/createUser")
    @PreAuthorize("hasAnyAuthority('CREATE_USER')")
    public ResponseDTO createUser(@RequestBody UserRegisterRequest entity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.userManagementService.userRegistration(entity, userDetails.getUsername());
    }

    @PutMapping("/updateUserProfile")
    @PreAuthorize("hasAnyAuthority('UPDATE_USER')")
    public ResponseDTO updateUserProfile(@RequestBody UpdateUserProfileRequest entity) {
        return this.userManagementService.updateUserProfile(entity);
    }

    @PutMapping("/updateUserRole")
    @PreAuthorize("hasAnyAuthority('UPDATE_USER')")
    public ResponseDTO updateUserRole(@RequestBody UpdateUserRoleRequest entity) {
        return this.userManagementService.updateUserRole(entity);
    }

    @GetMapping("/userList")
    @PreAuthorize("hasAnyAuthority('VIEW_USER')")
    public List<UserResponse> userList() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.userManagementService.usersList(userDetails.getUsername());
    }

    @GetMapping("/clientList")
    @PreAuthorize("hasAnyAuthority('VIEW_USER')")
    public List<UserResponse> clientList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.userManagementService.usersList(userDetails.getUsername());
    }

    @GetMapping("/userListByRole")
    @PreAuthorize("hasAnyAuthority('VIEW_USER')")
    public List<UserResponse> userListByRole(@RequestParam("roleId") Long roleId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.userManagementService.usersListByRole(roleId, userDetails.getUsername());
    }

    @GetMapping("/activationNumCheck")
    public ResponseDTO activationNumCheck(@RequestParam("activationNO") String number) {
        return this.userManagementService.actNoCheck(number);
    }

    @PostMapping("/setUserNameAndPassword")
    public ResponseDTO setUserNameAndPassword(@RequestBody UserNameAndPasswordRequest userNameAndPasswordDto) {
        return this.userManagementService.setUserNameAndPassword(userNameAndPasswordDto);
    }

    @PostMapping("/resetUserPassword")
    @PreAuthorize("hasAnyAuthority('CREATE_USER')")
    public ResponseDTO resetUserPassword(@RequestBody PasswordResetRequest resetDto) {
        return this.userManagementService.resetUserPassword(resetDto);
    }

    @DeleteMapping("/deleteUser")
    @PreAuthorize("hasAnyAuthority('DELETE_USER')")
    public ResponseDTO deleteUser(@RequestParam("userId") Long userId) {
        return this.userManagementService.deleteUser(userId);
    }

    @PutMapping("/suspendUser")
    @PreAuthorize("hasAnyAuthority('UPDATE_USER')")
    public ResponseDTO suspendUser(@RequestParam("userId") Long userId) {
        return this.userManagementService.suspendUser(userId);
    }

    @PutMapping("/reactivateUser")
    @PreAuthorize("hasAnyAuthority('UPDATE_USER')")
    public ResponseDTO reactivateUser(@RequestParam("userId") Long userId) {
        return this.userManagementService.reactivateUser(userId);
    }
}
