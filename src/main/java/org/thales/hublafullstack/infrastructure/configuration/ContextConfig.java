package org.thales.hublafullstack.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thales.hublafullstack.infrastructure.api.service.TransactionService;
import org.thales.hublafullstack.infrastructure.gateway.TransactionSqlGateway;

@Configuration
public class ContextConfig {

  private final TransactionSqlGateway transactionSqlGateway;

  public ContextConfig(TransactionSqlGateway transactionSqlGateway) {
    this.transactionSqlGateway = transactionSqlGateway;
  }

  @Bean
  public TransactionService transactionService() {
    return new TransactionService(transactionSqlGateway);
  }

}
