package org.thales.hublafullstack.domain.seller;

import org.thales.hublafullstack.domain.Aggregate;
import org.thales.hublafullstack.domain.product.ProductValidator;

import java.time.Instant;

public class Seller extends Aggregate<SellerId> implements ISeller {

    private final String name;
    private final Instant createdAt;

    private Seller(String name, Instant createdAt) {
        super(SellerId.unique());
        this.name = name;
        this.createdAt = createdAt;
    }

    public static Seller of(String name) {
        Instant now = Instant.now();
        return new Seller(name, now);
    }

    public String getName() {
        return name;
    }

    @Override
    public void validate() {
        new SellerValidator().validate(this);
    }
}
