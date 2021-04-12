package com.example.configclient;

import feign.Response;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;

public class ApiErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        System.out.println(methodKey);
        System.out.println(response);

        return HttpServerErrorException.create(HttpStatus.INTERNAL_SERVER_ERROR, response.toString(), null, null, null);
    }
}
