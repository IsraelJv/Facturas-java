package org.israeljv.appfacturas.modelo;

public class ItemBill {
    private final int amount;
    private final Product product;

    public ItemBill(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public float calculateAmount() {
        return this.amount * this.product.getPrice();
    }

    @Override
    public String toString() {
        return product.toString() + "\t" + amount + "\t" + calculateAmount();
    }
}
