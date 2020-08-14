package com.jeka.nik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceTwoApp {

    @RequestMapping("/")
    public String home() {
        return "Service Two, hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceTwoApp.class, args);
    }
}
