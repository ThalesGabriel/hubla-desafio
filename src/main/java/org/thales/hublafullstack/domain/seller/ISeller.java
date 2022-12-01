package org.thales.hublafullstack.domain.seller;

import org.thales.hublafullstack.shared.notification.INotification;

public interface ISeller {

    public String getName();
    public INotification getNotification();
    public boolean equals(Object o);
    int hashCode();

}
