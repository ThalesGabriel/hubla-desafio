package org.thales.hublafullstack.domain.transaction;

import org.thales.hublafullstack.domain.Validator;

public class TransactionValidator extends Validator<Transaction> {

  @Override
  public void validate(Transaction transaction) {
    checkPrice(transaction);
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
