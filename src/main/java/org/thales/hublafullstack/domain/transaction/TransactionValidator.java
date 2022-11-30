package org.thales.hublafullstack.domain.transaction;

import org.thales.hublafullstack.domain.Validator;
import org.thales.hublafullstack.domain.transaction.product.IProductValidator;
import org.thales.hublafullstack.domain.transaction.seller.ISellerValidator;

public class TransactionValidator extends Validator<Transaction> {

  private final IProductValidator iProductValidator;
  private final ISellerValidator iSellerValidator;

  public TransactionValidator(
          IProductValidator iProductValidator,
          ISellerValidator iSellerValidator) {
    this.iProductValidator = iProductValidator;
    this.iSellerValidator = iSellerValidator;
  }

  @Override
  public void validate(Transaction transaction) {
    checkPrice(transaction);
    this.iProductValidator.validate(transaction.getProduct(), transaction.getNotification());
    this.iSellerValidator.validate(transaction.getSeller(), transaction.getNotification());
  }

  private void checkPrice(Transaction transaction) {
    if (transaction.getPrice() == null){
      transaction.getNotification().append(String.format("STRING_SHOULD_NOT_BE_NULL", "PRICE_STR"), "CLASS_STR");
      return;
    }
    else if (transaction.getPrice() < 0)
      transaction.getNotification().append(String.format("PRICE_INVALID", "PRICE_STR"), "CLASS_STR");
  }

}
