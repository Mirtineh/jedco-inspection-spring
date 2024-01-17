package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.*;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserResponse;

import java.util.List;

public interface UserManagementService {
    ResponseDTO userRegistration(UserRegisterRequest userRegistrationDto, String username);

    ResponseDTO updateUserProfile(UpdateUserProfileRequest updateUserProfile);

    List<UserResponse> usersList();

    ResponseDTO deleteUser(Long id);

    ResponseDTO suspendUser(Long id);

    ResponseDTO reactivateUser(Long id);

    List<UserResponse> usersListByRole(Long roleId);

    ResponseDTO actNoCheck(String number);

    ResponseDTO setUserNameAndPassword(UserNameAndPasswordRequest userNameAndPasswordDto);

    ResponseDTO updateUserRole(UpdateUserRoleRequest updateRole);

    ResponseDTO resetUserPassword(PasswordResetRequest resetDto);

}
