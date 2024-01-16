package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.ProblemType;
import com.jedco.jedcoinspectionspring.rest.responses.ProblemTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProblemTypeMapper {
    ProblemTypeResponse toProblemTypeResponse(ProblemType problemType);
}
