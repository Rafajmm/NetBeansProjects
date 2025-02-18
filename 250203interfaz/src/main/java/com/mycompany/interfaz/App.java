package com.mycompany.interfaz;

public class App {
    
    void pruebaVoz(){
        
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Sonido p;
        p=new Perro();
        p.voz();
        System.out.println(p.getClass().getSimpleName());
        
    }
}
