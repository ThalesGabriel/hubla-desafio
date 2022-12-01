package org.thales.hublafullstack.infrastructure.gateway.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.thales.hublafullstack.infrastructure.gateway.transaction.output.TransactionOutput;

import java.util.List;
import java.util.Map;

public interface TransactionRepository extends JpaRepository<TransactionJpaEntity, String> {

    @Query("SELECT p.name as product, t.seller.name as seller, t.type as type, t.price as price, sum(t.price) as sumprice FROM TransactionJpaEntity t INNER JOIN t.product p GROUP BY t.product.name, t.seller.name, t.type")
    List<TransactionOutput> findAllGroupedTransactions(String name);

}
