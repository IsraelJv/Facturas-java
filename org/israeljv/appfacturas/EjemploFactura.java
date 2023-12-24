package org.israeljv.appfacturas;

import org.israeljv.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setIdCustomer("12345");
        customer.setName("Israel");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese una descripción de la factura: ");
        Bill bill = new Bill(s.nextLine(), customer);

        Product product;

        System.out.println();

        for (int i = 0; i < 2; i++) {
            product = new Product();
            System.out.print("Ingrese producto n° " + product.getCode() + ": ");
            product.setName(s.nextLine());

            System.out.print("Ingrese el precio: ");
            product.setPrice(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            bill.addItemBill(new ItemBill(s.nextInt(), product));

            System.out.println();
            s.nextLine();
        }
        System.out.println(bill.toString());
    }
}
