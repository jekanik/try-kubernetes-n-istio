package com.jeka.nik;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@SpringBootApplication
public class ServiceOneApp {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    @RequestMapping("/")
    public String home() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                                 .uri(URI.create("http://service-two"))
                                 .GET()
                                 .build();

        var response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("Response: {}, headers: {}, body: {}", response, response.headers(), response.body());

        return "Service One, hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApp.class, args);
    }
}
