package com.finance.planningservice.config;

import com.finance.planningservice.dto.RequestDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic AllowanceApprovedEvent() {
        return new NewTopic("allowance-Approved-topic", 1, (short) 1);
    }

}
