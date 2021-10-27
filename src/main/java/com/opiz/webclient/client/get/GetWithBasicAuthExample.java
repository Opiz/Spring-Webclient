package com.opiz.webclient.client.get;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opiz.webclient.models.Employee;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.opiz.webclient.utils.JsonOrXmlPrettyPrint.prettyPrintJson;


@Component
public class GetWithBasicAuthExample {

    public static final String USER_NAME = "tom";
    public static final String PASSWORD = "123";

    static final String URL_EMPLOYEES = "http://localhost:8080/employees";


    @Bean
    public static void getWithBasicAuth() throws JsonProcessingException {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        //
        // Authentication
        //
        String auth = USER_NAME + ":" + PASSWORD;
        byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
        String authHeader = "Basic " + new String(encodeAuth);
        headers.set("Authorization", authHeader);
        //
        headers.setAccept(List.of(
                MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE)));

        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
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

        // Response as JSON String
        String prettyPrint = prettyPrintJson(json);

        System.out.println(prettyPrint);

        // Response as POJO
        List<Employee> list = new ObjectMapper()
                .readerFor(new TypeReference<List<Employee>>(){})
                .readValue(json);

        System.out.println(list);
    }
}
