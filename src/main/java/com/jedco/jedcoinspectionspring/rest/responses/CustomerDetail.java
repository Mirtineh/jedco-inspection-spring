package com.jedco.jedcoinspectionspring.rest.responses;

public record CustomerDetail(
        String name,
        String address,
        String contactNo,
        String accNo,
        boolean canVend
) {
}
