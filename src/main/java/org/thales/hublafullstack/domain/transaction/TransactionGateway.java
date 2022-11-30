package org.thales.hublafullstack.domain.transaction;

import org.thales.hublafullstack.domain.transaction.product.Product;

import java.util.List;

public interface TransactionGateway {

  Product create(Product product);
  List<Product> findAll();

}
