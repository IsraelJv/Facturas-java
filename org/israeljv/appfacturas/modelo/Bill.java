package org.israeljv.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Bill {

    public static final int MAX_ITEMS = 12;
    private static int lastIdBill;

    private int idBill;
    private String description;
    private Date dateBill;
    private Customer customer;
    private ItemBill[] items;
    private int identifyItems;

    public Bill(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
        this.items = new ItemBill[MAX_ITEMS];
        this.idBill = ++lastIdBill;
        this.dateBill = new Date();
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateBill() {
        return dateBill;
    }

    public void setDateBill(Date dateBill) {
        this.dateBill = dateBill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ItemBill[] getItems() {
        return items;
    }

    public void addItemBill(ItemBill item) {
        if (identifyItems < MAX_ITEMS) {
            this.items[identifyItems++] = item;
        }
    }

    public float calculateTotal() {
        float total = 0;
        for (int i = 0; i < identifyItems; i++) {
            total += this.items[i].calculateAmount();
        }
        return total;
    }

    public String generateDetail() {
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(idBill)
                .append("\nCliente: ")
                .append(customer.getName())
                .append("\t Clave cliente: ")
                .append(customer.getIdCustomer())
                .append("\nDescripción: ")
                .append(description)
                .append("\n")
                .append("Fecha de emisión: ")
                .append(df.format(this.dateBill))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (int i = 0; i < identifyItems; i++) {
            sb.append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("\nGran Total: ")
                .append(calculateTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generateDetail();
    }
}
