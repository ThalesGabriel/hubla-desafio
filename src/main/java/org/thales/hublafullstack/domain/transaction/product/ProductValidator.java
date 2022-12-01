package org.thales.hublafullstack.domain.transaction.product;

import org.thales.hublafullstack.shared.notification.INotification;

public class ProductValidator implements IProductValidator {

  @Override
  public void validate(IProduct product, INotification notification) {
    String productName = product.getValue();

    if (productName == null) {
      notification.append(String.format("STRING_SHOULD_NOT_BE_NULL", "CPF_STR"), "USER_STR");
      return;
    } else if (productName.isEmpty()) {
      notification.append(String.format("STRING_SHOULD_NOT_BE_BLANK", "CPF_STR"), "USER_STR");
    }
  }
}
