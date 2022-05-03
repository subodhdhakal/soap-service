package com.wsdl.soapservice.controller;

import com.wsdl.soapservice.client.SoapClient;
import com.wsdl.soapservice.stub.DetailsType;
import com.wsdl.soapservice.stub.GetBankResponseType;
import com.wsdl.soapservice.stub.GetBankType;
import com.wsdl.soapservice.stub.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SoapController {

    @Autowired
    private SoapClient soapClient;

    @Value("${soap.service.url:null}")
    private String url;

    @GetMapping
    public DetailsType sum(@RequestParam String code) {
        ObjectFactory objectFactory = new ObjectFactory();
        GetBankType type = new GetBankType();
        type.setBlz(code);

        GetBankResponseType response = soapClient.getBank(url, objectFactory.createGetBank(type));
        return response.getDetails();
    }
}
