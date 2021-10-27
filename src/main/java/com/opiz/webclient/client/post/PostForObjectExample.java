package com.opiz.webclient.client.post;

import com.opiz.webclient.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PostForObjectExample {

    static final String URL_CREATE_EMPLOYEE = "http://localhost:8080/employee";


    @Bean
    public static void postForObject() {

        Long empNo = 11L;

        Employee newEmployee = new Employee(empNo, "Tom", "Clerk");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
        headers.setContentType(MediaType.APPLICATION_XML);

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);

        // Send request with POST method
        Employee employee = restTemplate.postForObject(
                URL_CREATE_EMPLOYEE,
                requestBody,
                Employee.class);

        if (employee != null && employee.getEmpNo() != null) {
            System.out.println("Employee created: " + employee);
        }
        else {
            System.out.println("Something wrong!");
        }
    }
}
