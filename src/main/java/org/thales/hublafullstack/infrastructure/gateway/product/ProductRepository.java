package org.thales.hublafullstack.infrastructure.gateway.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.thales.hublafullstack.infrastructure.gateway.seller.SellerJpaEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductJpaEntity, String> {

}
