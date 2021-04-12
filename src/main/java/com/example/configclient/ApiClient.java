package com.example.configclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "config-server", configuration = FeignConfig.class)    // consul service discovery
//@FeignClient(name = "${feign.api.name}", url = "${feign.api.url}", configuration = FeignConfig.class)
@RequestMapping("/api")
public interface ApiClient {
    @GetMapping("/success")
    public String success();

    @GetMapping("/400")
    public String badRequest();

    @GetMapping("/500")
    public String internalServerError();

    @GetMapping("/echo/{echo}")
    public String echo(@PathVariable("echo") String echo);
}
