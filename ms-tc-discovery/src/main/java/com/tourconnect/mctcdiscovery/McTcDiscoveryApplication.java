package com.tourconnect.mctcdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class McTcDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(McTcDiscoveryApplication.class, args);
    }

}
