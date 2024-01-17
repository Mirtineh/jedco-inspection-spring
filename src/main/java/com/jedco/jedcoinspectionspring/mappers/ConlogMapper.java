package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.conlog.ConfirmCustResult;
import com.jedco.jedcoinspectionspring.rest.responses.CustomerDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConlogMapper {

    @Mapping(target = "name", source = "custVendDetail.name")
    @Mapping(target = "contactNo", source = "custVendDetail.contactNo")
    @Mapping(target = "canVend", source = "custVendConfig.canVend")
    @Mapping(target = "address", source = "custVendDetail.address")
    @Mapping(target = "accNo", source = "custVendDetail.accNo")
    CustomerDetail toCustomerDetail(ConfirmCustResult confirmCustResult);
}
