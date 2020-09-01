package com.jeka.nik;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class ServiceOneApp {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    @GetMapping("/")
    public String home() {
        return "Service One, hello world!";
    }

    @SneakyThrows
    @GetMapping("/ping")
    public String ping() {
        var request = HttpRequest.newBuilder()
                                 .uri(URI.create("http://service-two/internal"))
                                 .GET()
                                 .build();

        var response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Response: {}, headers: {}, body: {}", response, response.headers(), response.body());
        return "Response from 3rd party: " + response.body();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApp.class, args);
    }
}
