package com.finance.accountservice.service;

import com.finance.accountservice.domain.Account;
import com.finance.accountservice.dto.AccountRequestDTO;
import com.finance.accountservice.dto.AccountResponseDTO;
import com.finance.accountservice.event.AccountCreatedEvent;
import com.finance.accountservice.exception.AccountNotFoundException;
import com.finance.accountservice.mapper.AccountMapper;
import com.finance.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

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

    public AccountResponseDTO getAccount(UUID id) {

        Account account = repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        return AccountMapper.toDTO(account);
    }

    public AccountResponseDTO credit(UUID id, BigDecimal amount) {

        Account account = repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));

        account.setCreditLimit(amount);

        repository.save(account);

        return AccountMapper.toDTO(account);
    }

}
