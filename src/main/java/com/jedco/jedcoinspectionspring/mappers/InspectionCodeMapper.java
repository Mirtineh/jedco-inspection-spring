package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.InspectionCode;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionCodesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InspectionCodeMapper {
    InspectionCodesResponse toResponse(InspectionCode inspectionCode);
}
