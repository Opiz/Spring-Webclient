package com.opiz.webclient.client.get;

import com.opiz.webclient.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
public class GetPojoWithHeaderExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";

    @Bean
    public static void getAllEmployeesWithHeaders() {

        // HTTP Headers
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(List.of(
                MediaType.valueOf(MediaType.APPLICATION_XML_VALUE)));

        // Request to return XML format
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<Employee[]>: To get result as Employee[]
        HttpEntity<Employee[]> entity = new HttpEntity<>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers
        ResponseEntity<Employee[]> response = restTemplate.exchange(
                URL_EMPLOYEES,
                HttpMethod.GET,
                entity,
                Employee[].class
        );

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            Employee[] list = response.getBody();

            if (list != null)
                Arrays.stream(list)
                        .forEach(System.out::println);
        }
    }
}
