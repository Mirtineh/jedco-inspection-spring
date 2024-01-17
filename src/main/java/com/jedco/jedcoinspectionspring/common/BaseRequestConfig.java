package com.jedco.jedcoinspectionspring.common;

import com.jedco.jedcoinspectionspring.conlog.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class BaseRequestConfig {
    @Value("${conlog.serverId}")
    private String vendingServerID;

    @Value("${conlog.opname}")
    private String opName;
    @Value("${conlog.deviceId}")
    private String deviceId;
    @Value("${conlog.terminalId}")
    private String terminalId;

    @Value("${conlog.passwd}")
    private String password;

    public BaseReq setCommonFields(BaseReq request) {
        request.setAuthCred(getAuthCred());
        request.setVendingServerID(vendingServerID);
        request.setClientID(getClientId());
        request.setTerminalID(getTerminalId());
        request.setMsgID(getMessageId());
        return request;
    }

    public ConfirmMeterReq setMeterNo(ConfirmMeterReq request, String meterNo) {
        VendIDMethod vendIDMethod = getVendIDMethod(meterNo);
        request.setIdMethod(vendIDMethod);
        return request;
    }

    public ConfirmCustomerReq setMeterNo(ConfirmCustomerReq request, String meterNo) {
        VendIDMethod vendIDMethod = getVendIDMethod(meterNo);
        request.setIdMethod(vendIDMethod);
        return request;
    }

    public ClearTamperReq setMeterNo(ClearTamperReq request, String meterNo) {
        VendIDMethod vendIDMethod = getVendIDMethod(meterNo);
        request.setIdMethod(vendIDMethod);
        return request;
    }

    private static VendIDMethod getVendIDMethod(String meterNo) {
        VendIDMethod vendIDMethod = new VendIDMethod();
        MeterNumber meterNumber = new MeterNumber();
        meterNumber.setMsno(meterNo);
        vendIDMethod.setMeterIdentifier(meterNumber);
        return vendIDMethod;
    }

    private AuthCred getAuthCred() {
        AuthCred authCred = new AuthCred();
        authCred.setOpName(opName);
        authCred.setPassword(password);
        return authCred;
    }

    private DeviceID getClientId() {
        EANDeviceID clientID = new EANDeviceID();
        clientID.setEan(deviceId);
        return clientID;
    }

    private DeviceID getTerminalId() {
        EANDeviceID terminalID = new EANDeviceID();
        terminalID.setEan(terminalId);
        return terminalID;
    }

    public MsgID getMessageId() {
        String dateTime;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        dateTime = dateFormat.format(date);
        String uniqueId ="2209001";
        var msgID = new MsgID();
        msgID.setDateTime(dateTime);
        msgID.setUniqueNumber(new BigInteger(uniqueId));
        return msgID;

    }

    public AbstractCreditVendReq setVendDetails(AbstractCreditVendReq request, String meterNo, BigDecimal amount, String currency) {
        PurchaseValueCurrency purchaseValue = new PurchaseValueCurrency();
        Currency currency1 = new Currency();
        currency1.setSymbol(currency);
        currency1.setValue(amount);
        purchaseValue.setAmt(currency1);
        request.setIdMethod(getVendIDMethod(meterNo));
        request.setPurchaseValue(purchaseValue);
        return request;
    }
}
