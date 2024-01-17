package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.client.WebserviceClient;
import com.jedco.jedcoinspectionspring.common.BaseRequestConfig;
import com.jedco.jedcoinspectionspring.conlog.ConfirmCustomerReq;
import com.jedco.jedcoinspectionspring.conlog.ConfirmCustomerResp;
import com.jedco.jedcoinspectionspring.exceptions.XmlVendException;
import com.jedco.jedcoinspectionspring.mappers.ConlogMapper;
import com.jedco.jedcoinspectionspring.rest.responses.ConfirmCustomerResponse;
import com.jedco.jedcoinspectionspring.rest.responses.CustomerDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfirmCustomerServiceImpl implements ConfirmCustomerService {
    private final BaseRequestConfig baseRequestConfig;
    private final WebserviceClient webserviceClient;
    private final ConlogMapper conlogMapper;
    @Override
    public ConfirmCustomerResponse confirmCustomer(String meterNumber) {
        ConfirmCustomerReq req = new ConfirmCustomerReq();
        req = (ConfirmCustomerReq) baseRequestConfig.setCommonFields(req);
        req = baseRequestConfig.setMeterNo(req, meterNumber);
        try {
            ConfirmCustomerResp resp = webserviceClient.confirmCustomer(req);
            if(!resp.getConfirmCustResult().isEmpty()){
                CustomerDetail customerDetail=conlogMapper.toCustomerDetail(resp.getConfirmCustResult().getFirst());
                return new ConfirmCustomerResponse(true, "Customer Found in the system", customerDetail);
            }
            return new ConfirmCustomerResponse(false, "Customer Not Found in the system", null);
        } catch (XmlVendException ex) {
            String message = ex.getMessage();
            if (ex.getMessage().contains("luhn check")) {
                message = "Invalid Meter Number : " + message;
            }
            return new ConfirmCustomerResponse(false, message, null);
        } catch (Exception ex) {
            return new ConfirmCustomerResponse(false, "Vending Server Error", null);
        }
    }
}
