/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.problema5;

/**
 *
 * @author rafa
 */
public class Problema5 {

    public static void main(String[] args) {
        Password una=new Password();
        Password otra=new Password(20);
        
        System.out.println(una.getContraseña());
        System.out.println(otra.getContraseña());
        System.out.println(otra.esFuerte());
        
        una.encriptar(3);
        System.out.println(una.getContraseña());
        
        una.desencriptar(3);
        System.out.println(una.getContraseña());
    }
}
