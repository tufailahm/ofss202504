package com.training.investmentsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InvestmentsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestmentsAppApplication.class, args);
    }

}
