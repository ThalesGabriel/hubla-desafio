package org.thales.hublafullstack.infrastructure.gateway.product;

import org.thales.hublafullstack.domain.product.Product;
import org.thales.hublafullstack.domain.seller.Seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "product")
public class ProductJpaEntity {

  @Id
  private String id;

  @Column(name = "name", length = 30, nullable = false)
  private String name;

  @Column(
          name = "created_at",
          columnDefinition = "DATETIME(6)"
  )
  private Instant createdAt;

  private ProductJpaEntity() {
  }

  private ProductJpaEntity(String id, String product, Instant created_at) {
    this.id = id;
    this.name = product;
    this.createdAt = created_at;
  }

  public static ProductJpaEntity of(Product product) {
    Instant now = Instant.now();
    return new ProductJpaEntity(product.getId().getValue(), product.getName(), now);
  }
}
