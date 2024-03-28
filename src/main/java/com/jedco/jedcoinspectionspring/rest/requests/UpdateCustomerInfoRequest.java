package com.jedco.jedcoinspectionspring.rest.requests;

public record UpdateCustomerInfoRequest(
        String customerName,
        String meterNumber,
        String phoneNumber,
        String problemType
) {
}
