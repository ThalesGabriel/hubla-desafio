package org.thales.hublafullstack.domain.product;

import org.thales.hublafullstack.shared.notification.INotification;

public interface IProduct {

    public String getName();
    public INotification getNotification();
    public boolean equals(Object o);
    int hashCode();

}
