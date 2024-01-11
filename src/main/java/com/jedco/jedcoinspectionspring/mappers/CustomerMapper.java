package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.Customer;
import com.jedco.jedcoinspectionspring.rest.responses.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    @Mapping(target = "tx_no", source = "txNo")
    CustomerResponse toCustomerResponse(Customer customer);
}
