package org.thales.hublafullstack.domain.transaction.type;

import java.util.List;

public enum TransactionType {
    SALE_PRODUCER(1, "Venda produtor", "Entrada", "+"),
    AFFILIATE_SALE(2, "Venda afiliado", "Entrada", "+"),
    PAID_COMMISSION(3, "Comissão paga", "Saída", "-"),
    RECEIVED_COMMISSION(4, "Comissão recebida", "Entrada", "+");

    private final int type;
    private final String description;
    private final String nature;
    private final String signal;

    TransactionType(int type, String description, String nature, String signal) {
        this.type = type;
        this.description = description;
        this.nature = nature;
        this.signal = signal;
    }


    public static TransactionType getByType(int type) {
        return List.of(TransactionType.values()).stream().filter(transactionType -> transactionType.type == type).toList().get(0);
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getNature() {
        return nature;
    }

    public String getSignal() {
        return signal;
    }
}
