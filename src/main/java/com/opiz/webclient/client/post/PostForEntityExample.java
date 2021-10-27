package com.opiz.webclient.client.post;

import com.opiz.webclient.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PostForEntityExample {

    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";


    @Bean
    public static void postForEntity() {

        Employee newEmployee = new Employee(11L, "Tom", "Clerk");

        RestTemplate restTemplate = new RestTemplate();

        // Data attatched to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee);

        // Send request with POST method
        ResponseEntity<Employee> result = restTemplate.postForEntity(
                URL_CREATE_EMPLOYEE,
                requestBody,
                Employee.class);

        System.out.println("Status Code: " + result.getStatusCode());

        // Code 200
        if (result.getStatusCode() == HttpStatus.OK) {
            Employee employee = result.getBody();
            System.out.println(employee);
        }
    }
}
