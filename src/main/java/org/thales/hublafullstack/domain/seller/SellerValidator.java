package org.thales.hublafullstack.domain.seller;

public class SellerValidator implements ISellerValidator {

  @Override
  public void validate(ISeller seller) {
    String productName = seller.getName();

    if (productName == null) {
      seller.getNotification().append(String.format("STRING_SHOULD_NOT_BE_NULL", "CPF_STR"), "USER_STR");
      return;
    } else if (productName.isEmpty()) {
      seller.getNotification().append(String.format("STRING_SHOULD_NOT_BE_BLANK", "CPF_STR"), "USER_STR");
    }
  }

}
