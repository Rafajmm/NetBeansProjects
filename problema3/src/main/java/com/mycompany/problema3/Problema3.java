/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problema3;

/**
 *
 * @author rafa
 */
public class Problema3 {

    public static void main(String[] args) {
        Vagon uno=new Vagon(true),otro=new Vagon(false);
        
        System.out.println(uno.toString());
        System.out.println(otro.toString());
        
        uno.llenarVagon();
        otro.llenarVagon();
        
        System.out.println(uno.toString());
        System.out.println(otro.toString());
        
        
        
        
        Tren tren = new Tren(10, "Madrid", "Barcelona", 50.0, 30.0);

        
        tren.llenarTren();

        
        System.out.println(tren.toString());

        
        double totalVentas = tren.ventas();
        System.out.println("Total de ventas de tickets: " + totalVentas + " euros");
    }
}
