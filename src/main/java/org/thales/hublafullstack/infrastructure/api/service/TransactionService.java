package org.thales.hublafullstack.infrastructure.api.service;

import org.springframework.stereotype.Service;
import org.thales.hublafullstack.domain.transaction.Transaction;
import org.thales.hublafullstack.infrastructure.api.pagination.Pagination;
import org.thales.hublafullstack.infrastructure.api.pagination.SearchQuery;
import org.thales.hublafullstack.infrastructure.gateway.TransactionJpaEntity;
import org.thales.hublafullstack.infrastructure.gateway.TransactionSqlGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {

    private TransactionSqlGateway gateway;

    public TransactionService(TransactionSqlGateway gateway) {
        this.gateway = gateway;
    }

    public void create(String[] rows) throws Exception {
        ArrayList<Transaction> transacoes = new ArrayList<>();

        for (String row : rows) {
            transacoes.add(Transaction.of(row));
        }

        gateway.save(transacoes);

    }

    public Map<Object, Map<Object, Map<Object, List<TransactionJpaEntity>>>> listTransactions(SearchQuery searchQuery) {
        var pagination = gateway.findAll(searchQuery);
        return pagination.items().stream().collect(
                Collectors.groupingBy(transaction -> transaction.getProduct(),
                        Collectors.groupingBy(transaction -> transaction.getSeller(),
                                Collectors.groupingBy(transaction -> transaction.getType())
                        )
                )
        );
    }
}
