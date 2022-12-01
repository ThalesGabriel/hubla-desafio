package org.thales.hublafullstack.infrastructure.gateway.product;

import org.springframework.stereotype.Component;
import org.thales.hublafullstack.domain.product.Product;

@Component
public class ProductSqlGateway {

    private final ProductRepository repository;

    public ProductSqlGateway(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductJpaEntity save(Product product) {
        return this.repository.save(ProductJpaEntity.of(product));
    }

}
