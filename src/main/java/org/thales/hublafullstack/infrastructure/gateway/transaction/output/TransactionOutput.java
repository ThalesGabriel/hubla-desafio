package org.thales.hublafullstack.infrastructure.gateway.transaction.output;

public interface TransactionOutput {

    public String getProduct();
    public String getSeller();
    public Integer getType();
    public Integer getPrice();
    public Integer getSumPrice();

}
