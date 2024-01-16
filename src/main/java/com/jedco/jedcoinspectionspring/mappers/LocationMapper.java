package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.Location;
import com.jedco.jedcoinspectionspring.rest.responses.LocationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {
    LocationResponse toLocationResponse(Location location);
}
