package org.thales.hublafullstack.domain.transaction.seller;

public class Seller implements ISeller{

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
