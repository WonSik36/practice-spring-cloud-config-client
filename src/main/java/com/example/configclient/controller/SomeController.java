package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {
    @Value("${my.profile.is}")
    private String myProfile;

    @GetMapping("/")
    public String myProfileIs() {
        return myProfile;
    }
}
