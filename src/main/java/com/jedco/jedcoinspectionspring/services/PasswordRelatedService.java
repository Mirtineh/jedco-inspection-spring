package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

public interface PasswordRelatedService {
    ResponseDTO changePassword(String oldPassword, String confirmPassword, String newPassword, String username);
}
