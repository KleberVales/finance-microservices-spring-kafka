package com.finance.accountservice.service;

import com.finance.accountservice.domain.Account;
import com.finance.accountservice.dto.AccountRequestDTO;
import com.finance.accountservice.dto.AccountResponseDTO;
import com.finance.accountservice.event.AccountCreatedEvent;
import com.finance.accountservice.event.consumer.AllowanceApprovedEvent;
import com.finance.accountservice.event.consumer.CardTransactionReceivedEvent;
import com.finance.accountservice.mapper.AccountMapper;
import com.finance.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public AccountResponseDTO createAccount(AccountRequestDTO request) {

        Account account = AccountMapper.toEntity(request);

        repository.save(account);

        kafkaTemplate.send("account-created-topic",
                new AccountCreatedEvent(account.getId(), account.getUserId()));

        return AccountMapper.toDTO(account);

    }

    @KafkaListener(topics = "allowance-Approved-topic", groupId = "planning-service-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeAllowanceApproved(AllowanceApprovedEvent event) {
        System.out.println("Evento recebido: " + event);

        Account account = new Account();

        account.setId(event.getId());
        account.setUsedAmount(event.getAccount_amount());
        repository.save(account);

    }

    @KafkaListener(topics = "card-transaction-received-topic", groupId = "account-consumer-group")
    public void debited(CardTransactionReceivedEvent event){

        Account account = repository.findById(event.getAccount_id())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        account.setId(event.getAccount_id());
        account.setUsedAmount(account.getUsedAmount().subtract(event.getDebit()));

        repository.save(account);

    }

}
