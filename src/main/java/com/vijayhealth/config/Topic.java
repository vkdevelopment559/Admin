package com.vijayhealth.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Topic {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("vijay",3,(short)1);
    }
}
