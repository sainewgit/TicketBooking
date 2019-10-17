package com.ticketprovider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

@Configuration
public class SingleServiceTestConfiguration {

    @Bean
    @Lazy
    String baseUrl(Environment environment) {
        return "http://localhost:" +environment.getProperty("local.server.port") +
                "/ticketprovider-service";
    }
	
}
