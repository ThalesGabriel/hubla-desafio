package org.thales.hublafullstack.domain.transaction.seller;

import org.thales.hublafullstack.shared.notification.INotification;

public interface ISellerValidator {

  public abstract void validate(Seller seller, INotification notification);

}
