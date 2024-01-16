package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.RoleDefinition;
import com.jedco.jedcoinspectionspring.models.UserAction;
import com.jedco.jedcoinspectionspring.models.UserRole;
import com.jedco.jedcoinspectionspring.rest.responses.RoleDefinitionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.UserActionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleDefinitionMapper {
    @Mapping(target = "userActionList", source = "roleDefinition.userAction", qualifiedByName = "mapUserActionList")
    @Mapping(target = "roleName", source = "userRole.roleName")
    @Mapping(target = "roleId", source = "userRole.id")
    RoleDefinitionResponse toResponse(RoleDefinition roleDefinition, UserRole userRole);

    @Mapping(target = "groupName", source = "actionGroup.name")
    @Mapping(target = "groupId", source = "actionGroup.id")
    UserActionResponse toUserActionResponse(UserAction userAction);

    @Named("mapUserActionList")
    default List<UserActionResponse> mapUserActionList(UserAction userAction){
        return Collections.singletonList(toUserActionResponse(userAction));
    }
}
