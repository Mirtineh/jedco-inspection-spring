package com.jedco.jedcoinspectionspring.rest.responses;

public record CustomerResponseDto(
        boolean status,
        String message,
        CustomerResponse customerResponse
) {
}
