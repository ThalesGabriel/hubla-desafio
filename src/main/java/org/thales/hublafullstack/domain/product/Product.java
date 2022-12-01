package org.thales.hublafullstack.domain.product;

import org.thales.hublafullstack.domain.Aggregate;
import org.thales.hublafullstack.domain.ValueObject;

public class Product extends Aggregate<ProductId> implements IProduct {

    private final String name;

    private Product(String name) {
        super(ProductId.unique());
        this.name = name;
    }

    public static Product of(String value) {
        return new Product(value);
    }

    public String getName() {
        return name;
    }

    @Override
    public void validate() {
        new ProductValidator().validate(this);
    }
}
