package org.thales.hublafullstack.infrastructure.gateway.transaction;

public class Novo {

    private String product;
    private String seller;
    private Integer type;
    private Integer price;

    public Novo(String product, String seller, Integer type, Integer price) {
        this.product = product;
        this.seller = seller;
        this.type = type;
        this.price = price;
    }

    public String product() {
        return product;
    }

    public String seller() {
        return seller;
    }

    public Integer type() {
        return type;
    }

    public Integer price() {
        return price;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
