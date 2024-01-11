package com.jedco.jedcoinspectionspring.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VendException extends RuntimeException {
    public VendException(String s) {
    }
}
