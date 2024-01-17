package com.jedco.jedcoinspectionspring.configuration;

import com.jedco.jedcoinspectionspring.client.WebserviceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConlogConfiguration {
    @Value("${conlog.wsdl.url}")
    private String webserviceUrl;

    @Bean
    Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.jedco.jedcoinspectionspring.conlog");
        return marshaller;
    }

    @Bean
    public WebserviceClient webserviceClient(Jaxb2Marshaller marshaller) {
        WebserviceClient client = new WebserviceClient();
        client.setDefaultUri(webserviceUrl);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
