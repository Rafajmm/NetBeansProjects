/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio823;

/**
 *
 * @author usuario
 */
public class Ejercicio823 {

    public static void main(String[] args) {
        Rectangulo rec=new Rectangulo(2,3);
        Triangulo tri=new Triangulo(2,3);
        
        rec.getAltura();
        double ar=rec.area();
        double at=tri.area();
        System.out.println("Area de rectangulo: "+ar+". Area del triangulo: "+at);
    }
}
