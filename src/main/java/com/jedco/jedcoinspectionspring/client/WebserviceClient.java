package com.jedco.jedcoinspectionspring.client;


import com.jedco.jedcoinspectionspring.conlog.*;
import com.jedco.jedcoinspectionspring.exceptions.VendException;
import com.jedco.jedcoinspectionspring.exceptions.XmlVendException;
import jakarta.xml.bind.JAXBElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.client.SoapFaultClientException;

import javax.xml.transform.Source;
import java.io.IOException;

@Slf4j
public class WebserviceClient extends WebServiceGatewaySupport {

    public ConfirmCustomerResp confirmCustomer(ConfirmCustomerReq request) throws IOException {
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<ConfirmCustomerReq> jaxbElement = objectFactory.createConfirmCustomerReq(request);
        return invokeWebService(jaxbElement, ConfirmCustomerResp.class);
    }

    private <T, R> R invokeWebService(JAXBElement<T> requestElement, Class<R> responseType) throws IOException {
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        webServiceTemplate.setCheckConnectionForFault(false);

        try {
            Object response = webServiceTemplate.marshalSendAndReceive(requestElement);
            if (response instanceof JAXBElement<?>) {
                Object value = ((JAXBElement<?>) response).getValue();
                if (responseType.isInstance(value)) {
                    return responseType.cast(value);
                }
            }
            throw new RuntimeException("Unexpected response type: " + response.getClass().getName());
        } catch (SoapFaultClientException ex) {
            SoapFaultDetail soapFaultDetail = ex.getSoapFault().getFaultDetail();
            if (soapFaultDetail == null) {
                throw ex;
            }
            SoapFaultDetailElement detailElementChild = soapFaultDetail.getDetailEntries().next();
            Source detailSource = detailElementChild.getSource();
            JAXBElement<?> fault = (JAXBElement<?>) webServiceTemplate.getUnmarshaller().unmarshal(detailSource);
            if (fault.getValue() instanceof XMLVendFaultResp xmlVendResponse) {
                throw new XmlVendException(xmlVendResponse.getFault().getDesc(), xmlVendResponse);
            }
            throw new VendException("Unexpected fault type: " + fault.getValue().getClass().getName());
        }
    }
}
