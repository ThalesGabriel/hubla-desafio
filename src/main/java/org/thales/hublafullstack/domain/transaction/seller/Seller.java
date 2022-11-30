package org.thales.hublafullstack.domain.transaction.seller;

import org.thales.hublafullstack.domain.transaction.product.Product;

public class Seller {

    private final String value;

    private Seller(String value) {
        this.value = value;
    }

    public static Seller of(String value) {
        return new Seller(value);
    }

    public String getValue() {
        return value;
    }
}
