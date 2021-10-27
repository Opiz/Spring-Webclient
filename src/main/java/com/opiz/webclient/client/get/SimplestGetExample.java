package com.opiz.webclient.client.get;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.opiz.webclient.utils.JsonOrXmlPrettyPrint.prettyPrintXml;


@Component
public class SimplestGetExample {

    static final String URL_EMPLOYEES = "http://localhost:8080//employees";

    static final String URL_EMPLOYEES_XML = "http://localhost:8080//employee/1.xml";
    static final String URL_EMPLOYEES_JSON = "http://localhost:8080//employee/1.json";


    @Bean
    public static void getAllEmployeesXml() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        String xml = restTemplate.getForObject(URL_EMPLOYEES, String.class);
        String prettyPrintXml = prettyPrintXml(xml);

        System.out.println(prettyPrintXml);
    }
}
