package org.thales.hublafullstack.domain.transaction;

import org.thales.hublafullstack.shared.notification.INotification;

public interface ITransaction {

    public boolean equals(Object o);
    public INotification getNotification();
    int hashCode();

}
