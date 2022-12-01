package org.thales.hublafullstack.infrastructure.gateway.transaction;

import org.springframework.stereotype.Component;
import org.thales.hublafullstack.infrastructure.gateway.transaction.output.TransactionOutput;

import java.util.List;

@Component
public class TransactionSqlGateway {

  private final TransactionRepository transactionRepository;

  public TransactionSqlGateway(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public void save(TransactionJpaEntity transaction) {
    this.transactionRepository.saveAndFlush(transaction);
  }

  public List<TransactionOutput> findAll() {
    return this.transactionRepository.findAllGroupedTransactions("");
  }

}
