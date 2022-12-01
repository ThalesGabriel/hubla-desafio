package org.thales.hublafullstack.domain.product;

import org.thales.hublafullstack.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class ProductId extends Identifier {

    private final String value;

    public ProductId(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static ProductId unique() {
        return ProductId.from(UUID.randomUUID());
    }

    public static ProductId from(String id) {
        return new ProductId(id);
    }

    public static ProductId from(UUID id) {
        return new ProductId(id.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return getValue().equals(productId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
