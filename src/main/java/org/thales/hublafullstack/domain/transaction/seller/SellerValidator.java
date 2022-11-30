package org.thales.hublafullstack.domain.transaction.seller;

import org.thales.hublafullstack.domain.transaction.product.IProductValidator;
import org.thales.hublafullstack.domain.transaction.product.Product;
import org.thales.hublafullstack.shared.notification.INotification;

public class SellerValidator implements ISellerValidator {

  @Override
  public void validate(Seller seller, INotification notification) {
    String productName = seller.getValue();

    if (productName == null) {
      notification.append(String.format("STRING_SHOULD_NOT_BE_NULL", "CPF_STR"), "USER_STR");
      return;
    } else if (productName.isEmpty()) {
      notification.append(String.format("STRING_SHOULD_NOT_BE_BLANK", "CPF_STR"), "USER_STR");
    }
  }

}
