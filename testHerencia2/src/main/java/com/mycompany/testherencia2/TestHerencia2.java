package com.mycompany.testherencia2;
import java.util.*;

public class TestHerencia2 {

    public static void main(String[] args) {
        ProductoF fresco = new ProductoF("Papas","30-01-25", "F123-789", "01-01-25", "España");
        ProductoR refrigerado = new ProductoR("Arándanos","02-02-25", "R456-456", "ORG789");
        ProductoC congelado = new ProductoC("Merluza","31-10-25", "C789-123", -18.0);

        // Mostrar información de cada producto
        System.out.println("Producto Fresco:");
        fresco.mostrar();
        System.out.println();

        System.out.println("Producto Refrigerado:");
        refrigerado.mostrar();
        System.out.println();

        System.out.println("Producto Congelado:");
        congelado.mostrar();
    }
}
