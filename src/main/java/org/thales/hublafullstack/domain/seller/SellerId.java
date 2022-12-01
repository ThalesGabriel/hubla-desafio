package org.thales.hublafullstack.domain.seller;

import org.thales.hublafullstack.domain.Identifier;
import org.thales.hublafullstack.domain.product.ProductId;

import java.util.Objects;
import java.util.UUID;

public class SellerId extends Identifier {

    private final String value;

    public SellerId(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static SellerId unique() {
        return SellerId.from(UUID.randomUUID());
    }

    public static SellerId from(String id) {
        return new SellerId(id);
    }

    public static SellerId from(UUID id) {
        return new SellerId(id.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerId sellerId = (SellerId) o;
        return getValue().equals(sellerId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}