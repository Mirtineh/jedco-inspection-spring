package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.*;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserResponse;

import java.security.Principal;
import java.util.List;

public interface UserManagementService {
    public ResponseDTO userRegistration(UserRegisterRequest userRegistrationDto, String username);
    public ResponseDTO updateUserProfile(UpdateUserProfileRequest updateUserProfile);
    public List<UserResponse> usersList(String username);
    public ResponseDTO deleteUser(Long id);
    public ResponseDTO suspendUser(Long id);
    public ResponseDTO reactivateUser(Long id);
    public List<UserResponse> usersListByRole(Long roleId, String username);
    public ResponseDTO actNoCheck(String number);
    public ResponseDTO setUserNameAndPassword(UserNameAndPasswordRequest userNameAndPasswordDto);
    public ResponseDTO updateUserRole(UpdateUserRoleRequest updateRole);
    public ResponseDTO resetUserPassword(PasswordResetRequest resetDto);

}
