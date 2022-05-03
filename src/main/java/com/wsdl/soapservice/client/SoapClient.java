package com.wsdl.soapservice.client;

import com.wsdl.soapservice.stub.GetBankResponseType;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class SoapClient extends WebServiceGatewaySupport {

    public GetBankResponseType getBank(String url, Object request) {
        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request);
        return (GetBankResponseType) response.getValue();
    }
}
