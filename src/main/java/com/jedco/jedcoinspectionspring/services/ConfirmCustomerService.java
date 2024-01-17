package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ConfirmCustomerResponse;

public interface ConfirmCustomerService {
    ConfirmCustomerResponse confirmCustomer(String meterNumber);
}
