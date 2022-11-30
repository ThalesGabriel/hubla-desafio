package org.thales.hublafullstack.domain;


import org.thales.hublafullstack.shared.notification.INotification;

public abstract class Aggregate<ID extends Identifier> extends Entity<ID> {

  protected Aggregate(ID id) {
    super(id);
  }
  private INotification notification;

  public INotification getNotification() {
    return notification;
  }

  public void setNotification(INotification notification) {
    this.notification = notification;
  }

  public abstract void validate();
}
