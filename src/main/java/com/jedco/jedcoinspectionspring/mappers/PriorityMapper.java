package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.Priority;
import com.jedco.jedcoinspectionspring.rest.responses.PriorityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PriorityMapper {
    PriorityResponse toPriorityResponse(Priority priority);
}
