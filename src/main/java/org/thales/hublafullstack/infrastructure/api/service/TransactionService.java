package org.thales.hublafullstack.infrastructure.api.service;

import org.thales.hublafullstack.domain.product.Product;
import org.thales.hublafullstack.domain.seller.Seller;
import org.thales.hublafullstack.domain.transaction.Transaction;
import org.thales.hublafullstack.infrastructure.gateway.product.ProductSqlGateway;
import org.thales.hublafullstack.infrastructure.gateway.seller.SellerSqlGateway;
import org.thales.hublafullstack.infrastructure.gateway.transaction.TransactionJpaEntity;
import org.thales.hublafullstack.infrastructure.gateway.transaction.TransactionSqlGateway;
import org.thales.hublafullstack.infrastructure.gateway.transaction.output.TransactionOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    private final TransactionSqlGateway gateway;
    private final ProductSqlGateway productSqlGateway;
    private final SellerSqlGateway sellerSqlGateway;

    public TransactionService(TransactionSqlGateway gateway, ProductSqlGateway productSqlGateway, SellerSqlGateway sellerSqlGateway) {
        this.gateway = gateway;
        this.productSqlGateway = productSqlGateway;
        this.sellerSqlGateway = sellerSqlGateway;
    }

    public void create(String[] rows) throws Exception {
        ArrayList<Transaction> transacoes = new ArrayList<>();

        for (String row : rows) {
            transacoes.add(Transaction.of(row));
        }

        for (Transaction transaction :
                transacoes) {
            final var product = productSqlGateway.save((Product) transaction.getProduct());
            final var seller = sellerSqlGateway.save((Seller) transaction.getSeller());
            gateway.save(TransactionJpaEntity.of(transaction, product, seller));
        }

    }

    public List<TransactionOutput> listTransactions() {
        return (List<TransactionOutput>) gateway.findAll().stream().collect(
                Collectors.groupingBy(TransactionOutput::getProduct)
        );
    }
}
