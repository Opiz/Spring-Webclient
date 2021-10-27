package com.opiz.webclient.client.delete;

import com.opiz.webclient.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SimpleDeleteExample {


    @Bean
    public static void simpleDelete() {

        RestTemplate restTemplate = new RestTemplate();

        // empNO = 1L
        String resourceUrl = "http://localhost:8080/employee/1";

        // Before
        Employee employee = restTemplate.getForObject(resourceUrl, Employee.class);

        if (employee != null) {
            System.out.println("(Client side) Employee before delete: ");
            System.out.println(employee);
        } else {
            System.out.println("Employee not found!");
        }

        // Send request with DELETE method
        restTemplate.delete(resourceUrl);

        // Get
        employee = restTemplate.getForObject(resourceUrl, Employee.class);

        if (employee != null) {
            System.out.println("(Client side) Employee after delete: ");
            System.out.println(employee);
        } else {
            System.out.println("(Client side) Employee after delete: ");
            System.out.println("Employee not found!");
        }
    }
}
