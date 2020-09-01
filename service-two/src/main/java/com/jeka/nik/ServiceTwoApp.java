package com.jeka.nik;

import java.util.concurrent.ThreadLocalRandom;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceTwoApp {

    @GetMapping("/")
    public String home() {
        return "Service Two, hello world!";
    }

    @SneakyThrows
    @GetMapping("/internal")
    public String internal() {
        long nextLong = ThreadLocalRandom.current().nextLong(1, 1000);
        return "ID: " + nextLong;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceTwoApp.class, args);
    }
}
