package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.*;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {
    @Override
    public ResponseDTO userRegistration(UserRegisterRequest userRegistrationDto, String username) {
        return null;
    }

    @Override
    public ResponseDTO updateUserProfile(UpdateUserProfileRequest updateUserProfile) {
        return null;
    }

    @Override
    public List<UserResponse> usersList(String username) {
        return null;
    }

    @Override
    public ResponseDTO deleteUser(Long id) {
        return null;
    }

    @Override
    public ResponseDTO suspendUser(Long id) {
        return null;
    }

    @Override
    public ResponseDTO reactivateUser(Long id) {
        return null;
    }

    @Override
    public List<UserResponse> usersListByRole(Long roleId, String username) {
        return null;
    }

    @Override
    public ResponseDTO actNoCheck(String number) {
        return null;
    }

    @Override
    public ResponseDTO setUserNameAndPassword(UserNameAndPasswordRequest userNameAndPasswordDto) {
        return null;
    }

    @Override
    public ResponseDTO updateUserRole(UpdateUserRoleRequest updateRole) {
        return null;
    }

    @Override
    public ResponseDTO resetUserPassword(PasswordResetRequest resetDto) {
        return null;
    }
}
