package org.thales.hublafullstack.infrastructure.gateway.seller;

import org.thales.hublafullstack.domain.seller.Seller;
import org.thales.hublafullstack.domain.transaction.Transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "seller")
public class SellerJpaEntity {

  @Id
  private String id;

  @Column(name = "name", length = 30, nullable = false)
  private String name;

  @Column(
          name = "created_at",
          columnDefinition = "DATETIME(6)"
  )
  private Instant createdAt;

  private SellerJpaEntity() {
  }

  private SellerJpaEntity(String id, String seller, Instant created_at) {
    this.id = id;
    this.name = seller;
    this.createdAt = created_at;
  }

  public static SellerJpaEntity of(Seller seller) {
    Instant now = Instant.now();
    return new SellerJpaEntity(seller.getId().getValue(), seller.getName(), now);
  }
}
