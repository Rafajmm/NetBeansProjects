package com.mycompany.ejercicio721;
import java.util.*;

public class Ejercicio721 {

    public static void main(String[] args) {
        Integer miArray[]={1,2,3,4,5},ma2[]={5,6,7,8,9};
        boolean b;
        
        Conjunto c=new Conjunto(miArray), c2=new Conjunto(ma2), c3=new Conjunto(), c4=new Conjunto();
        c3.insertar(c2);
        
        Conjunto.interseccion(c2, c).mostrar();
        b=c.pertenece(3);
        System.out.println(b);
        c.eliminar(3);
        c.insertar(c2);
        c.mostrar();
        c.eliminar(c2);
        c.mostrar();
        c.insertar(c2);
        
        System.out.println(Conjunto.incluido(c2, c));
        Conjunto.union(c, c2).mostrar();
        
        while(c4.numeroElementos()<5){            
            c4.insertar((int)(Math.random()*49)+1);
        }
        c4.mostrar();
        
        Conjunto.diferenciaS(c, c2).mostrar();
    }
}
