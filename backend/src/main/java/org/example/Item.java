package org.example;

public class Item {
    Product product;
    int quantity;

    public Item() {
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Double countPrice() {
        return product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
