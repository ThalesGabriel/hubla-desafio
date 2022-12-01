package org.thales.hublafullstack.infrastructure.gateway.transaction;

import org.springframework.stereotype.Component;
import org.thales.hublafullstack.infrastructure.api.pagination.SearchQuery;

import java.util.List;
import java.util.Map;

@Component
public class TransactionSqlGateway {

  private final TransactionRepository transactionRepository;

  public TransactionSqlGateway(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public void save(TransactionJpaEntity transaction) {
    this.transactionRepository.saveAndFlush(transaction);
  }

  public List<Map> findAll() {

    return this.transactionRepository.findAllTickersByUser("");
  }

}
