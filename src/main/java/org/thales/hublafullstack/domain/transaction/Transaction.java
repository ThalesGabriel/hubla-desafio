package org.thales.hublafullstack.domain.transaction;

import org.thales.hublafullstack.domain.Aggregate;
import org.thales.hublafullstack.domain.transaction.product.Product;
import org.thales.hublafullstack.domain.transaction.product.ProductValidator;
import org.thales.hublafullstack.domain.transaction.seller.Seller;
import org.thales.hublafullstack.domain.transaction.seller.SellerValidator;
import org.thales.hublafullstack.domain.transaction.type.TransactionType;
import org.thales.hublafullstack.shared.notification.Notification;

import java.time.Instant;

public class Transaction extends Aggregate<TransactionId> {

    private TransactionType transactionType;
    private Instant createdAt;
    private Product product;
    private Seller seller;
    private Integer price;

    private Transaction(TransactionType transactionType, Instant createdAt, Product iProduct, Integer price, Seller iSeller) {
        super(TransactionId.unique());
        this.transactionType = transactionType;
        this.createdAt = createdAt;
        this.product = iProduct;
        this.price = price;
        this.seller = iSeller;
        this.setNotification(new Notification());
    }

    public static Transaction of(String row) throws Exception {
        try {
            String type = row.trim().substring(0, 1);
            String date = row.trim().substring(1, 26);
            String product_name = row.trim().substring(26, 56).trim();
            String price = row.trim().substring(56, 66);
            String seller = row.trim().substring(66, row.length());
            return new Transaction(TransactionType.getByType(Integer.parseInt(type)), Instant.parse(date), Product.of(product_name), Integer.parseInt(price), Seller.of(seller));
        } catch (Exception e) {
            throw new Exception("Erro na criação");
        }
    }

    @Override
    public void validate() {
        new TransactionValidator(new ProductValidator(), new SellerValidator()).validate(this);
    }

    public void validateProduct() {
//        this.cpf = Cpf.format(this.cpf.getValue());
    }

    public void validateSeller() {
//        this.cpf = Cpf.format(this.cpf.getValue());
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }
}
