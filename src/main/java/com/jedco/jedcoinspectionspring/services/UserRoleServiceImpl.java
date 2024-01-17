package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.UserMapper;
import com.jedco.jedcoinspectionspring.models.UserRole;
import com.jedco.jedcoinspectionspring.repositories.UserRoleRepository;
import com.jedco.jedcoinspectionspring.rest.requests.UserRoleUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.UserRoleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserMapper userMapper;
    @Override
    public ResponseDTO userRoleUpdate(UserRoleUpdateRequest userRoleUpdateDto) {
        try {
            Optional<UserRole> optionalUserRole = userRoleRepository.findById(userRoleUpdateDto.id());
            if (userRoleUpdateDto.name() == null) {
                return new ResponseDTO(false, "Role name is empty");
            }
            if(optionalUserRole.isEmpty()){
                return new ResponseDTO(false, "Role Not found");
            }
            var userRole= optionalUserRole.get();
            if (userRole.getStatus().getId().equals(1L)) {
                userRole.setRoleName(userRoleUpdateDto.name());
                userRole.setRoleDescription(userRoleUpdateDto.description());
//                userRole.setUpdatedOn(new Date());
                userRoleRepository.save(userRole);
                return new ResponseDTO(true, "User role updated successfully");
            } else {
                return new ResponseDTO(false, "Deactivated Role");
            }
        } catch (Exception e) {
            //TODO handle error
            e.printStackTrace();
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public List<UserRoleResponse> userRoleList() {
        List<UserRole> userRoles= userRoleRepository.findAll();
        return userRoles.stream().map(userMapper::toUserRoleResponse).toList();
    }
}
