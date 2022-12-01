package org.thales.hublafullstack.infrastructure.gateway.seller;

import org.springframework.stereotype.Component;
import org.thales.hublafullstack.domain.seller.Seller;

@Component
public class SellerSqlGateway {

    private final SellerRepository repository;

    public SellerSqlGateway(SellerRepository repository) {
        this.repository = repository;
    }


    public SellerJpaEntity save(Seller seller) {
        return this.repository.save(SellerJpaEntity.of(seller));
    }

}
