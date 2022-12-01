package org.thales.hublafullstack.infrastructure.gateway;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionJpaEntity, String> {

  Page<TransactionJpaEntity> findAll(Specification<TransactionJpaEntity> whereClause, Pageable page);

}
