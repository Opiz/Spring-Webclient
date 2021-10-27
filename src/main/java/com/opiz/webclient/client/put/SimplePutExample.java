package com.opiz.webclient.client.put;

import com.opiz.webclient.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SimplePutExample {

    static final String URL_UPDATE_EMPLOYEE = "http://localhost:8080/employee";
    static final String URL_EMPLOYEE_PREFIX = "http://localhost:8080/employee";


    @Bean
    public static void simplePut() {

        Long empNo = 11L;

        Employee updatedInfo = new Employee(empNo, "Tom", "Clerk");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();

        // Data attatched to the request
        HttpEntity<Employee> requestBody = new HttpEntity<>(updatedInfo, headers);

        // Send request with PUT method
        restTemplate.put(URL_UPDATE_EMPLOYEE, requestBody);

        String resourceUrl = URL_EMPLOYEE_PREFIX + "/" + empNo;

        Employee employee = restTemplate.getForObject(resourceUrl, Employee.class);

        if (employee != null) {
            System.out.println("(Client side) Employee after update: ");
            System.out.println(employee);
        }
    }
}
