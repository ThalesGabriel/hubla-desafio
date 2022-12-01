package org.thales.hublafullstack.infrastructure.gateway.seller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerJpaEntity, String> {
}
