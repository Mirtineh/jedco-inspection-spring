package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.ActionGroup;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.models.UserAction;
import com.jedco.jedcoinspectionspring.models.UserRole;
import com.jedco.jedcoinspectionspring.rest.responses.ActionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.UserActionsListByGroupResponse;
import com.jedco.jedcoinspectionspring.rest.responses.UserResponse;
import com.jedco.jedcoinspectionspring.rest.responses.UserRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "groupName", source = "name")
    @Mapping(target = "groupId", source = "id")
    @Mapping(target = "groupDescription", source = "description")
    @Mapping(target = "actionsDtos", source = "userActions")
    UserActionsListByGroupResponse toUserAction(ActionGroup actionGroup);

    @Mapping(target = "userActionId", source = "id")
    @Mapping(target = "actionStatus", constant = "false")
    @Mapping(target = "action",source = "action" , qualifiedByName = "mapAction")
    ActionResponse toActionResponse(UserAction userAction);

    @Named("mapAction")
    default String mapAction(String action){
        String actionNameToLowerCase = action.toLowerCase();
        String actionNameFirstLatterInCapital = actionNameToLowerCase.substring(0, 1).toUpperCase()+actionNameToLowerCase.substring(1);
        return actionNameFirstLatterInCapital.replace('_',' ');
    }

    @Mapping(target = "userRoleName", source = "userRole.roleName")
    @Mapping(target = "userRoleId", source = "userRole.id")
    @Mapping(target = "userName", source = "username")
    @Mapping(target = "userId", source = "id")
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "statusName", source = "status.name")
    @Mapping(target = "statusId", source = "status.id")
    @Mapping(target = "phone", source = "phoneNo")
    @Mapping(target = "createdOn", source = "registeredDate")
    UserResponse toUserResponse(User user);

    @Mapping(target = "updateOn", ignore = true)
    @Mapping(target = "name", source = "roleName")
    @Mapping(target = "description", source = "roleDescription")
    @Mapping(target = "createdOn", source = "registeredOn")
    UserRoleResponse toUserRoleResponse(UserRole userRole);
}
