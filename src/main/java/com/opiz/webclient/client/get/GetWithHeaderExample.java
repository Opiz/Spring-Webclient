package com.opiz.webclient.client.get;

import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.opiz.webclient.utils.JsonOrXmlPrettyPrint.prettyPrintJson;

@Component
public class GetWithHeaderExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";


    @Bean
    public static void getAllEmployeesJson() {

        // HTTP Headers
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(List.of(
                MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)));

        //headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as String
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers
        ResponseEntity<String> response = restTemplate.exchange(
                URL_EMPLOYEES,
                HttpMethod.GET,
                entity,
                String.class);

        String json = response.getBody();
        String prettyPrintJson = prettyPrintJson(json);

        System.out.println(prettyPrintJson);
    }
}
