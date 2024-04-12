package ru.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "ru.mvc, ru.mvc.repositories")
@ComponentScan
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
}
