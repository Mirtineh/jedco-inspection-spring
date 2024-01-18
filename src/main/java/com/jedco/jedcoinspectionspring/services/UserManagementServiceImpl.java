package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.UserMapper;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.models.UserRole;
import com.jedco.jedcoinspectionspring.repositories.StatusRepository;
import com.jedco.jedcoinspectionspring.repositories.UserRepository;
import com.jedco.jedcoinspectionspring.repositories.UserRoleRepository;
import com.jedco.jedcoinspectionspring.rest.requests.*;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final StatusRepository statusRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public ResponseDTO userRegistration(UserRegisterRequest userRegistrationDto, String username) {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(username);

            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "Logged In User Not Found");
            }
            var loggedInUser = optionalUser.get();
            Optional<UserRole> optionalUserRole = userRoleRepository.findOneByIdAndStatus_Id(userRegistrationDto.userRoleId(), 1L);
            if (optionalUserRole.isEmpty()) {
                return new ResponseDTO(false, "User Role Not Found");

            }
            var userRole = optionalUserRole.get();
            User user = new User();

            user.setFirstName(userRegistrationDto.firstName());
            user.setLastName(userRegistrationDto.lastName());
            user.setEmail(userRegistrationDto.email());
            user.setPhoneNo(userRegistrationDto.phone());
            user.setUsername(userRegistrationDto.username());
            user.setPassword(this.passwordEncoder.encode(userRegistrationDto.password()));
            user.setUserRole(userRole);
            user.setStatus(statusRepository.findById(1L).get());
            user.setPasswordIndex(0L);
            user.setChangeCount(0L);
            user.setRegisteredDate(new Date());
            user.setRegisteredBy(loggedInUser.getId());
            user.setActivationNo("0");


            userRepository.save(user);
            return new ResponseDTO(true, "User created successfully");

        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public ResponseDTO updateUserProfile(UpdateUserProfileRequest updateUserProfile) {
        try {
            Optional<User> optionalUser = userRepository.findById(updateUserProfile.userId());
            Optional<UserRole> optionalUserRole = userRoleRepository.findOneByIdAndStatus_Id(updateUserProfile.userRoleId(), 1L);

            if (optionalUser.isPresent() && optionalUser.get().getStatus().getId().equals(1L) && optionalUserRole.isPresent()) {

                var user = optionalUser.get();
                var userRole = optionalUserRole.get();
                user.setFirstName(updateUserProfile.firstName());
                user.setLastName(updateUserProfile.lastName());
                user.setEmail(updateUserProfile.email());
                user.setPhoneNo(updateUserProfile.phone());
                user.setUserRole(userRole);
//                user.setUpdatedOn(new Date());
                userRepository.save(user);
                return new ResponseDTO(true, "User profile updated successfully");
            } else {
                return new ResponseDTO(false, "User Not Found!");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public List<UserResponse> usersList() {
        Long deletedStatus = 3L;
        List<User> users = userRepository.findByUsernameIsNotNullAndUsernameNotAndStatusId_Not("admin", deletedStatus);
        return users.stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public ResponseDTO deleteUser(Long id) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent() && optionalUser.get().getStatus().getId() != 3L) {
                var user= optionalUser.get();
                user.setStatus(statusRepository.findById(3L).get());
                userRepository.save(user);
                return new ResponseDTO(true, "Deleted Successfully");
            } else {

                return new ResponseDTO(false, "User not Found!");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public ResponseDTO suspendUser(Long id) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent() && optionalUser.get().getStatus().getId().equals(1L)) {
                var user = optionalUser.get();
                user.setStatus(statusRepository.findById(4L).get());
                userRepository.save(user);
                return new ResponseDTO(true, "Suspended Successfully");
            } else {
                return new ResponseDTO(false, "You can not suspend unActive user");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public ResponseDTO reactivateUser(Long id) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent() && optionalUser.get().getStatus().getId().equals(4L)) {
                var user = optionalUser.get();
                user.setStatus(statusRepository.findById(1L).get());
                userRepository.save(user);

                return new ResponseDTO(true, "Activated Successfully");
            } else
                return new ResponseDTO(false, "Pending user / already activated user / deleted user");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public List<UserResponse> usersListByRole(Long roleId) {
        Long deletedStatus = 3L;
        List<User> users = userRepository.findByUsernameIsNotNullAndUsernameNotAndUserRole_IdAndStatusId_Not("admin", roleId, deletedStatus);
        return users.stream().map(userMapper::toUserResponse).toList();
    }

    @Override
    public ResponseDTO actNoCheck(String number) {
        Optional<User> optionalUser = userRepository.findByActivationNo(number);

        return optionalUser.map(user -> new ResponseDTO(true, "Activation Number Matched For " + user.getFirstName() + " " + user.getLastName())).orElseGet(() -> new ResponseDTO(false, "Logged In User Not Found"));
    }

    @Override
    public ResponseDTO setUserNameAndPassword(UserNameAndPasswordRequest userNameAndPasswordDto) {
        Optional<User> optionalUser = userRepository.findByActivationNo(userNameAndPasswordDto.activationNo());
        Optional<User> optionalUserByuname = userRepository.findByUsername(userNameAndPasswordDto.userName());
        if (optionalUserByuname.isPresent()) {
            return new ResponseDTO(false, "username already taken!");
        }
        if (optionalUser.isEmpty()) {
            return new ResponseDTO(false, "User Not Found!");
        }
        var user = optionalUser.get();
        String hashPassword = this.passwordEncoder.encode(userNameAndPasswordDto.Password());
        user.setUsername(userNameAndPasswordDto.userName());
        user.setPassword(hashPassword);
        user.setStatus(statusRepository.findById(1L).get());
        user.setPasswordIndex(user.getPasswordIndex() == null ? 0L : user.getPasswordIndex() + 1);
        user.setChangeCount(user.getChangeCount() == null ? 0L : user.getChangeCount() + 1);

        userRepository.save(user);
        return new ResponseDTO(true, "Username and Password Set Successfully for " + user.getFirstName() + " " + user.getLastName());

    }

    @Override
    public ResponseDTO updateUserRole(UpdateUserRoleRequest updateRole) {
        try {
            Optional<User> optionalUser = userRepository.findById(updateRole.userId());
            Optional<UserRole> optionalUserRole = userRoleRepository.findOneByIdAndStatus_Id(updateRole.userRoleId(), 1L);

            if (optionalUser.isPresent() && optionalUser.get().getStatus().getId().equals(1L) && optionalUserRole.isPresent()) {
                var user = optionalUser.get();
                var userRole = optionalUserRole.get();
                user.setUserRole(userRole);
                userRoleRepository.save(userRole);

                return new ResponseDTO(true, "User profile updated successfully");
            } else {
                return new ResponseDTO(false, "User Not Found!");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public ResponseDTO resetUserPassword(PasswordResetRequest resetDto) {
        Optional<User> optionalUser = userRepository.findById(resetDto.userId());
        if (optionalUser.isEmpty()) {
            return new ResponseDTO(false, "User Not Found!");
        }

        if (resetDto.password() == null || resetDto.password().isEmpty()) {
            return new ResponseDTO(false, "Password Can Not Be Empty!");
        }
        if (resetDto.confirmPassword() == null || resetDto.confirmPassword().isEmpty()) {
            return new ResponseDTO(false, "Confrim Password Can Not Be Empty!");
        }
        if (!resetDto.password().equals(resetDto.confirmPassword())) {
            return new ResponseDTO(false, "Confirm Password Did Not Match!");
        }

        var user = optionalUser.get();
        String hashPassword = this.passwordEncoder.encode(resetDto.password());
        user.setPassword(hashPassword);
        user.setStatus(statusRepository.findById(1L).get());
        user.setPasswordIndex(user.getPasswordIndex() == null ? 0L : user.getPasswordIndex() + 1);
        user.setChangeCount(user.getChangeCount() == null ? 0L : user.getChangeCount() + 1);

        userRepository.save(user);
        return new ResponseDTO(true, "Password Set Successfully for " + user.getFirstName() + " " + user.getLastName());

    }
}
