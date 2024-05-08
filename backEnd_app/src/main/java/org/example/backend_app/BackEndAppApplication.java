package org.example.backend_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndAppApplication {

    public static void main(String[] args) {
        System.out.printf("hello world");
        SpringApplication.run(BackEndAppApplication.class, args);
    }

}
