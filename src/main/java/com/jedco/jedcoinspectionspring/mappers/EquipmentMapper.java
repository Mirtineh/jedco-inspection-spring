package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.Equipment;
import com.jedco.jedcoinspectionspring.rest.responses.EquipmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EquipmentMapper {
    EquipmentResponse toEquipmentResponse(Equipment equipment);
}
