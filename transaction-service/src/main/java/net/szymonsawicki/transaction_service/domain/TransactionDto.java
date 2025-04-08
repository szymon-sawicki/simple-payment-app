package net.szymonsawicki.transaction_service.domain;

import net.szymonsawicki.transaction_service.application.type.TransactionType;

import java.math.BigDecimal;

public record TransactionDto(Long userId, BigDecimal amount, TransactionType type) {
}
