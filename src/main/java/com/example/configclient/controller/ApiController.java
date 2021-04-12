package com.example.configclient.controller;

import com.example.configclient.ApiClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@RestController
public class ApiController {
    private final ApiClient apiClient;

    public ApiController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/success")
    public String success() {
        return apiClient.success();
    }

    @GetMapping("/400")
    public String badRequest() {
        return apiClient.badRequest();
    }

    @GetMapping("/500")
    public String internalServerError() {
        return apiClient.internalServerError();
    }

    @GetMapping("/echo/{echo}")
    public String echo(@PathVariable("echo") String echo) {
        return apiClient.echo(echo);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public String handleServerError(HttpServerErrorException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public String handleClientError(HttpClientErrorException ex) {
        return ex.getMessage();
    }
}
