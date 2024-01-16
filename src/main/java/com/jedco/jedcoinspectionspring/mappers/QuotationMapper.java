package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.Quotation;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.rest.responses.QuotationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuotationMapper {
    @Mapping(target = "registeredBy", source = "user", qualifiedByName = "mapRegisteredBy")
    @Mapping(target = "inspectionId", source = "inspection.id")
    QuotationResponse toQuotationResponse(Quotation quotation);
    @Named("mapRegisteredBy")
    default String mapRegisteredBy (User user){
        return user.getFirstName()+" "+user.getLastName();
    }
}
