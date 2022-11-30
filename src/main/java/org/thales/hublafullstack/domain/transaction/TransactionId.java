package org.thales.hublafullstack.domain.transaction;

import org.thales.hublafullstack.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class TransactionId extends Identifier {

  private final String value;

  public TransactionId(String value) {
    Objects.requireNonNull(value);
    this.value = value;
  }

  public static TransactionId unique() {
    return TransactionId.from(UUID.randomUUID());
  }

  public static TransactionId from(String id) {
    return new TransactionId(id);
  }

  public static TransactionId from(UUID id) {
    return new TransactionId(id.toString().toLowerCase());
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TransactionId userID = (TransactionId) o;
    return getValue().equals(userID.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }
}
