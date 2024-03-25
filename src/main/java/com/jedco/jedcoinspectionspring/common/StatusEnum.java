package com.jedco.jedcoinspectionspring.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
    Active,
    Pending,
    Deleted,
    Suspended,
    Registered,
    Completed,
    Approved,
    Sent_to_Sales,
    Accepted_in_Sales,
    Assessment_Requested,
    Assessment_Completed,
    Completed_in_Sales,
    Quotation_Requested,
    Quotation_Submitted,
    Assigned_to_Legal,
    Case_Opened,
    Court_Closed,
    Completed_in_Legal,
    Warrant_Issued,
    Taken_To_Court,
    Court_Hearing,
    Case_Closed,
    Case_Appealed,
    Court_Decision,
    Under_Investigation,
    Verdict_Reached,
    Payment_Settle
    ;

    @JsonCreator
    public static StatusEnum fromString(String value) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.toString().equalsIgnoreCase(value)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("Unknown UserType: " + value);
    }

    @JsonValue
    public String toString() {
        return this.name().toLowerCase().replace('_', '-');
    }
}
