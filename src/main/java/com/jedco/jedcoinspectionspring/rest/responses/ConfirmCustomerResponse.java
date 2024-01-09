package com.jedco.jedcoinspectionspring.rest.responses;

public record ConfirmCustomerResponse(
        boolean status,
        String message,
        CustomerDetail customerDetail
) {
}
