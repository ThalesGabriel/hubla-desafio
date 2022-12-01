package org.thales.hublafullstack.domain.product;

public class ProductValidator implements IProductValidator {

  @Override
  public void validate(IProduct product) {
    String productName = product.getName();

    if (productName == null) {
      product.getNotification().append(String.format("STRING_SHOULD_NOT_BE_NULL", "CPF_STR"), "USER_STR");
      return;
    } else if (productName.isEmpty()) {
      product.getNotification().append(String.format("STRING_SHOULD_NOT_BE_BLANK", "CPF_STR"), "USER_STR");
    }
  }
}
