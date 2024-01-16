package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.RoleDefinitionMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.*;
import com.jedco.jedcoinspectionspring.rest.requests.AddOrRemoveActionRequest;
import com.jedco.jedcoinspectionspring.rest.requests.RoleDefineRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.RoleDefinitionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleDefinitionServiceImpl implements RoleDefinitionService {
    private final UserRoleRepository userRoleRepository;
    private final StatusRepository statusRepository;
    private final UserActionRepository userActionRepository;
    private final RoleDefinitionRepository roleDefinitionRepository;
    private final UserRepository userRepository;

    private final RoleDefinitionMapper roleDefinitionMapper;

    @Override
    public ResponseDTO defineRole(RoleDefineRequest roleDefineDto) {
        try {
            Optional<UserRole> optionalUserRole = userRoleRepository.findByRoleName(roleDefineDto.userRoleName());
            Status activeStatus = statusRepository.findById(1L).get();
            if (optionalUserRole.isPresent()) {
                return new ResponseDTO(false, "Role Name already taken");
            }
            UserRole userRole = new UserRole();
            userRole.setRoleName(roleDefineDto.userRoleName());
            userRole.setRoleDescription(roleDefineDto.userRoleDescription());
            userRole.setStatus(activeStatus);
            userRoleRepository.save(userRole);

            List<Long> userActionids = roleDefineDto.userActions();
            userActionids.forEach((actionId) -> {
                UserAction userAction = userActionRepository.findById(actionId).get();
                RoleDefinition roleDefinition = new RoleDefinition();
                roleDefinition.setUserRole(userRole);
                roleDefinition.setUserAction(userAction);
                roleDefinition.setStatus(activeStatus);
                roleDefinitionRepository.save(roleDefinition);
            });
            return new ResponseDTO(true, "User role defined successfully");

        } catch (Exception e) {
            //TODO to error log
            e.printStackTrace();
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public ResponseDTO updateDefinedActions(AddOrRemoveActionRequest addOrRemoveActionDto) {
        try {
            Optional<UserRole> optionalUserRole = userRoleRepository.findById(addOrRemoveActionDto.userRoleId());
            if (optionalUserRole.isEmpty()) {
                return new ResponseDTO(false, "User Role not Found!");
            }
            var userRole = optionalUserRole.get();
            List<RoleDefinition> roleDefinitions = roleDefinitionRepository.findAllByUserRoleId(userRole.getId());
            List<Long> userActionIds = addOrRemoveActionDto.userActions();

            System.out.println("user ---------------------------- role  " + addOrRemoveActionDto.userRoleId());
            userActionIds.forEach(id -> {
                System.out.println("user ---------------------------- actions  " + id);
            });

            roleDefinitions.forEach((definition) -> {
//                    System.out.println("--------------------------------------------------- " + definition.getUserAction().getAction());
                if (!userActionIds.contains(definition.getId())) {
                    definition.setStatus(statusRepository.findById(3L).get());
                    roleDefinitionRepository.save(definition);
                }
            });
            userActionIds.forEach((userActionId) -> {
                Optional<RoleDefinition> optionalRoleDefinition = roleDefinitionRepository.findOneByUserAction_IdAndUserRole_Id(userActionId, userRole.getId());
                if (optionalRoleDefinition.isEmpty()) {
                    UserAction action = userActionRepository.findById(userActionId).get();
                    RoleDefinition roleDefinition = new RoleDefinition();
                    roleDefinition.setUserRole(userRole);
                    roleDefinition.setUserAction(action);
                    roleDefinition.setStatus(statusRepository.findById(1L).get());
                    roleDefinitionRepository.save(roleDefinition);
                }
            });
            return new ResponseDTO(true, " Role updated Successfully");


        } catch (Exception e) {
            //TODO error handling
            e.printStackTrace();
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public ResponseDTO deleteUserRole(Long userRoleId) {
        try {
            Optional<UserRole> optionalUserRole = userRoleRepository.findById(userRoleId);
            if (optionalUserRole.isEmpty()) {
                return new ResponseDTO(false, "User Role not Found!");
            }
            var userRole = optionalUserRole.get();
            Long deletedStatusId = 3L;
            List<User> users = userRepository.findAllByUserRole_IdAndStatusId_Not(userRoleId, deletedStatusId);
            if (!users.isEmpty()) {
                return new ResponseDTO(false, "There are users registered with this role");
            }
            Status deletedStatus = statusRepository.findById(3L).get();
            userRole.setStatus(deletedStatus);
            userRoleRepository.save(userRole);

            List<RoleDefinition> roleDefinitions = roleDefinitionRepository.findAllByUserRoleIdAndStatus_Id(userRoleId,1L);
            roleDefinitions.forEach((roleDefinition) -> {
                roleDefinition.setStatus(deletedStatus);
                roleDefinitionRepository.save(roleDefinition);
            });
            return new ResponseDTO(true, "Deleted Successfully!");


        } catch (Exception e) {
            //TODO handle error
            e.printStackTrace();
            return new ResponseDTO(false, "Operation Failed!");
        }
    }

    @Override
    public List<RoleDefinitionResponse> definedRolesList(Long userRoleId) {
        UserRole userRole= userRoleRepository.findById(userRoleId).get();
        //TODO check this method
        return userRole.getRoleDefinitions().stream().map(roleDefinition -> roleDefinitionMapper.toResponse(roleDefinition,userRole)).toList();
    }
}
