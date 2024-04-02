package com.jedco.jedcoinspectionspring.rest.requests;

public record UpdateCheckList(
        long id,
        boolean status,
        String remark
) {
}
