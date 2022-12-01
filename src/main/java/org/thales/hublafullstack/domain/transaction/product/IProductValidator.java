package org.thales.hublafullstack.domain.transaction.product;


import org.thales.hublafullstack.shared.notification.INotification;

public interface IProductValidator {

  public abstract void validate(IProduct product, INotification notification);

}
