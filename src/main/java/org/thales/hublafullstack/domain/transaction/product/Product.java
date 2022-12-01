package org.thales.hublafullstack.domain.transaction.product;

import org.thales.hublafullstack.domain.ValueObject;

public class Product extends ValueObject implements IProduct {

    private final String value;

    private Product(String value) {
        this.value = value;
    }

    public static Product of(String value) {
        return new Product(value);
    }

    public String getValue() {
        return value;
    }
}
