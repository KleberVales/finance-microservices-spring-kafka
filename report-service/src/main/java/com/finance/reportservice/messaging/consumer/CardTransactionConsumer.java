package com.finance.reportservice.messaging.consumer;

import com.finance.reportservice.event.CardTransactionReceivedEvent;
import com.finance.reportservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CardTransactionConsumer {

    private final ReportService reportService;

    @KafkaListener(topics = "card-transaction-received-topic")
    public void consume(CardTransactionReceivedEvent event) {
        reportService.processTransaction(event);
    }
}
