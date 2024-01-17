package com.jedco.jedcoinspectionspring.exceptions;



import com.jedco.jedcoinspectionspring.conlog.XMLVendFaultResp;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class XmlVendException extends RuntimeException {
    private final XMLVendFaultResp faultResp;

    public XmlVendException(String message, XMLVendFaultResp faultResp) {
        super(message);
        this.faultResp = faultResp;
    }
}
