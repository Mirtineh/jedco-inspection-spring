package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.CustomerResponseDto;

public interface CustomerService {
    public CustomerResponseDto getCustomer(String meterNo);
}
