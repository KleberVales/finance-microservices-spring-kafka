package com.finance.accountservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private BigDecimal creditLimit;

    private BigDecimal usedAmount;

    private BigDecimal availableLimit;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

}