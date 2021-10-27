package com.opiz.webclient.client.get;

import com.opiz.webclient.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Component
public class SimplestGetPojoExample {

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";


    @Bean
    public static void getAllEmployeesPojo() {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers
        Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);

        if (list != null) {
            Arrays.stream(list)
                    .forEach(System.out::println);
        }
    }
}
