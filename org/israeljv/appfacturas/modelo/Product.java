package org.israeljv.appfacturas.modelo;

public class Product {
    public static int lastCode;

    private final int code;
    private String name;
    private float price;

    public Product() {
        this.code = ++lastCode;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + "\t" + name + "\t" + price;
    }
}
