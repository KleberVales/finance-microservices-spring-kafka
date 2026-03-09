package com.finance.accountservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic accountCreatedTopic() {
        return new NewTopic("account-created-topic", 1, (short) 1);
    }

}

