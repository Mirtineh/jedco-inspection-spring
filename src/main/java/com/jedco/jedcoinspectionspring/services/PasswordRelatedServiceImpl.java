package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordRelatedServiceImpl implements PasswordRelatedService {
    @Override
    public ResponseDTO changePassword(String oldPassword, String confirmPassword, String newPassword, String username) {
        return null;
    }
}
