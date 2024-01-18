package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.exceptions.ResponseException;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.repositories.UserRepository;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordRelatedServiceImpl implements PasswordRelatedService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseDTO changePassword(String oldPassword, String confirmPassword, String newPassword, String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            //TODO check if the exception is handled correctly
            throw new ResponseException("User could not be identified! Login required!");
        }
        var user = optionalUser.get();
        if (!newPassword.equals(confirmPassword)) {
            throw new ResponseException("New Password and Confirm Password fields does not match");
        }

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new ResponseException("invalid password!");
        }

        String hashPassword = this.passwordEncoder.encode(newPassword);
        Long passwordIndex = 1L;
        Long changeCount = 1L;
        if (user.getChangeCount() != null) {
            changeCount = user.getChangeCount() + 1L;
        }

        user.setPassword(hashPassword);
        user.setPasswordIndex(passwordIndex);
        user.setChangeCount(changeCount);

        userRepository.save(user);
        return new ResponseDTO(true, "password changed Successfully");


    }
}
