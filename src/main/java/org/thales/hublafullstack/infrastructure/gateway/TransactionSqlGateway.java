package org.thales.hublafullstack.infrastructure.gateway;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.thales.hublafullstack.domain.transaction.Transaction;
import org.thales.hublafullstack.infrastructure.api.pagination.Pagination;
import org.thales.hublafullstack.infrastructure.api.pagination.SearchQuery;

import java.util.List;

@Component
public class TransactionSqlGateway {

  private final TransactionRepository transactionRepository;

  public TransactionSqlGateway(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }

  public void save(List<Transaction> transactions) {
    for (Transaction transaction :
            transactions) {
      this.transactionRepository.saveAndFlush(TransactionJpaEntity.of(transaction));
    }
  }

  public Pagination<TransactionJpaEntity> findAll(SearchQuery searchQuery) {
    final var page = PageRequest.of(
            searchQuery.page(),
            searchQuery.perPage()
    );

    final var pageResult =
            this.transactionRepository.findAll(page);

    return new Pagination<>(
            pageResult.getNumber(),
            pageResult.getSize(),
            pageResult.getTotalElements(),
            pageResult.toList()
    );
  }

}
