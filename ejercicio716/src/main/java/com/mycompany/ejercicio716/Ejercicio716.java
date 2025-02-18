package com.mycompany.ejercicio716;
import java.util.*;

public class Ejercicio716 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Punto2D p2=new Punto2D(3.4,5.8);
        Punto3D p3=new Punto3D(1.1,1.9,2.7);
        Punto4D p4=new Punto4D(1.1,1.9,2.7,4.0);
        Punto4D p41=new Punto4D(1.1,1.9,2.7,4.0);
        Punto4D p42=new Punto4D(1.1,1.9,2.7,5.0);
        System.out.println(p3.toString());
        
        p2.id();
        p2=p3;
        p2.id();
        p3.id();
        p4.id();
        
        System.out.println(p4.equals(p41));
        System.out.println(p4.equals(p42));
    }
}
