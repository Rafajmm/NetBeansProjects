package com.mycompany.herenciamultiple;
import java.util.*;

public class HerenciaFigura {

    public static void main(String[] args) {
        
        Cuadrado c=new Cuadrado(2.2);
        Rectangulo rec=new Rectangulo(3,6);
        
        
        rec.mostrar();
        c.mostrar();
        
        System.out.println("El color del objeto 'rec' es: "+Arrays.toString(rec.getColor()));
        System.out.println("El color del objeto 'c' es: "+Arrays.toString(c.getColor()));
        
        
        
    } 
}
