package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.CustomerLoad;
import com.jedco.jedcoinspectionspring.models.InspectionAssessment;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.rest.responses.CustomerLoadResponse;
import com.jedco.jedcoinspectionspring.rest.responses.LoadAssessmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssessmentMapper {
    @Mapping(target = "customerLoadDtos", source = "customerLoads")
    @Mapping(target = "registeredById", source = "user.id")
    @Mapping(target = "registeredBy", source = "user", qualifiedByName = "mapRegisteredBy")
    LoadAssessmentResponse toLoadAssessmentResponse(InspectionAssessment assessment);

    @Named("mapRegisteredBy")
    default String mapRegisteredBy (User user){
        return user.getFirstName()+" "+user.getLastName();
    }

    @Mapping(target = "equipmentId", source = "equipment.id")
    @Mapping(target = "equipment", source = "equipment.name")
    CustomerLoadResponse toCustomerLoadResponse(CustomerLoad customerLoad);


}
