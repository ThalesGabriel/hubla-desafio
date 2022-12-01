package org.thales.hublafullstack.infrastructure.gateway;

import org.thales.hublafullstack.domain.transaction.Transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "transaction")
public class TransactionJpaEntity {

  @Id
  private String id;

  @Column(name = "product", length = 30, nullable = false)
  private String product;

  @Column(name = "seller", length = 20, nullable = false)
  private String seller;

  @Column(name = "type", length = 11, nullable = false)
  private Integer type;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(
          name = "created_at",
          columnDefinition = "DATETIME(6)",
          nullable = false
  )
  private Instant created_at;

  private TransactionJpaEntity() {
  }

  public TransactionJpaEntity(String id, String product, String seller, Integer type, Integer price, Instant created_at) {
    this.id = id;
    this.product = product;
    this.seller = seller;
    this.type = type;
    this.price = price;
    this.created_at = created_at;
  }

  public static TransactionJpaEntity of(Transaction transaction) {
    return new TransactionJpaEntity(transaction.getId().getValue(), transaction.getProduct().getValue(), transaction.getSeller().getValue(), transaction.getTransactionType().getType(), transaction.getPrice(), transaction.getCreatedAt());
  }

  public String getId() {
    return id;
  }

  public String getProduct() {
    return product;
  }

  public String getSeller() {
    return seller;
  }

  public Integer getType() {
    return type;
  }

  public Integer getPrice() {
    return price;
  }

  public Instant getCreated_at() {
    return created_at;
  }
}
