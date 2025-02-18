package com.mycompany.ejercicio81;

public class Ejercicio81 {

    public static void main(String[] args) {
        Hora hs=new Hora(23,5);
        HoraExacta he=new HoraExacta(23,59,59);
        HoraExacta he2=new HoraExacta(23,59,59);
        System.out.println(hs.toString());
        System.out.println(he.toString());
        he.inc();
        System.out.println(he.toString());
        
        he.setHora(12);
        he.setMinuto(58);        
        he.setSegundo(30);
        System.out.println(he.toString());
        
        hs=he;
        
        System.out.println(he.equals(hs));
        System.out.println(hs.equals(he));
        System.out.println(he2.equals(he));
        
        
    }
}
