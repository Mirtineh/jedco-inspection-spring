package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.Status;
import com.jedco.jedcoinspectionspring.rest.responses.StatusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatusMapper {
    @Mapping(target = "statusName", source = "name")
    @Mapping(target = "statusId", source = "id")
    @Mapping(target = "statusDescription", source = "description")
    StatusResponse toStatusResponse(Status status);
}
