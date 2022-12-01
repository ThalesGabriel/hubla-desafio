package org.thales.hublafullstack.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thales.hublafullstack.infrastructure.api.service.TransactionService;
import org.thales.hublafullstack.infrastructure.gateway.product.ProductSqlGateway;
import org.thales.hublafullstack.infrastructure.gateway.seller.SellerSqlGateway;
import org.thales.hublafullstack.infrastructure.gateway.transaction.TransactionSqlGateway;

@Configuration
public class ContextConfig {

  private final TransactionSqlGateway transactionSqlGateway;
  private final ProductSqlGateway productSqlGateway;
  private final SellerSqlGateway sellerSqlGateway;

  public ContextConfig(TransactionSqlGateway transactionSqlGateway, ProductSqlGateway productSqlGateway, SellerSqlGateway sellerSqlGateway) {
    this.transactionSqlGateway = transactionSqlGateway;
    this.productSqlGateway = productSqlGateway;
    this.sellerSqlGateway = sellerSqlGateway;
  }

  @Bean
  public TransactionService transactionService() {
    return new TransactionService(transactionSqlGateway, productSqlGateway, sellerSqlGateway);
  }

}
