package com.tourconnect.mctcconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class McTcConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(McTcConfigApplication.class, args);
    }

}
