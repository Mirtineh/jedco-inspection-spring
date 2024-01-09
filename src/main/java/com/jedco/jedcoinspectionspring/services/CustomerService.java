package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto getCustomer(String meterNo);
}
