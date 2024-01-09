package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.security.Principal;

public interface PasswordRelatedService {
    public ResponseDTO changePassword(String oldPassword, String confirmPassword, String newPassword, String username);
}
