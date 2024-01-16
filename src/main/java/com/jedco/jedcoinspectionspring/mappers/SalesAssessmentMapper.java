package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.SalesAssessment;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.rest.responses.SalesAssessmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SalesAssessmentMapper {
    @Mapping(target = "registeredBy", source = "user",qualifiedByName = "mapRegisteredBy")
    @Mapping(target = "inspectionId", source = "inspection.id")
    SalesAssessmentResponse toResponse(SalesAssessment salesAssessment);
    @Named("mapRegisteredBy")
    default String mapRegisteredBy (User user){
        return user.getFirstName()+" "+user.getLastName();
    }

}
