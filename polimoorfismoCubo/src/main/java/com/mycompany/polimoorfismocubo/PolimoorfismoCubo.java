package com.mycompany.polimoorfismocubo;

public class PolimoorfismoCubo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Vector2D v1=new Vector2D(3,4);
        Vector2D v2=new Vector2D(1,2);
        
        Vector2D sumav1=v1.add(v2);
        Vector2D restav1=v1.substract(v2);
        Vector2D sumav2=v2.add(v1);
        Vector2D restav2=v2.substract(v1);
        
        System.out.println("Operaciones v1"+sumav1.toString()+" y "+restav1.toString());
        System.out.println("Operaciones v2"+sumav2.toString()+" y "+restav2.toString());
    }
}
