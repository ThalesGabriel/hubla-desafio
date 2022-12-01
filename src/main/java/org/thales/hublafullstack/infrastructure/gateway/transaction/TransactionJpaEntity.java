package org.thales.hublafullstack.infrastructure.gateway.transaction;

import org.thales.hublafullstack.domain.transaction.Transaction;
import org.thales.hublafullstack.infrastructure.gateway.product.ProductJpaEntity;
import org.thales.hublafullstack.infrastructure.gateway.seller.SellerJpaEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "transaction")
public class TransactionJpaEntity {

  @Id
  private String id;

  @ManyToOne
  @JoinColumn(name="product_id")
  private ProductJpaEntity product;

  @ManyToOne
  @JoinColumn(name="seller_id")
  private SellerJpaEntity seller;

  @Column(name = "type", length = 11, nullable = false)
  private Integer type;

  @Column(name = "price", nullable = false)
  private Integer price;

  @Column(
          name = "created_at",
          columnDefinition = "DATETIME(6)",
          nullable = false
  )
  private Instant createdAt;

  private TransactionJpaEntity() {
  }

  public TransactionJpaEntity(String id, ProductJpaEntity product, SellerJpaEntity seller, Integer type, Integer price, Instant createdAt) {
    this.id = id;
    this.product = product;
    this.seller = seller;
    this.type = type;
    this.price = price;
    this.createdAt = createdAt;
  }

  public static TransactionJpaEntity of(Transaction transaction, ProductJpaEntity product, SellerJpaEntity seller) {
    return new TransactionJpaEntity(transaction.getId().getValue(), product, seller, transaction.getTransactionType().getType(), transaction.getPrice(), transaction.getCreatedAt());
  }

  public String getId() {
    return id;
  }

  public ProductJpaEntity getProduct() {
    return product;
  }

  public SellerJpaEntity getSeller() {
    return seller;
  }

  public Integer getType() {
    return type;
  }
}
