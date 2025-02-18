
package com.mycompany.ejercicio721;
import java.util.*;

public class Conjunto {
    private Integer elementos[];
    
    Conjunto(){
        elementos=new Integer[0];
    }
    
    Conjunto(Integer array[]){
        elementos=Arrays.copyOf(array, array.length);
    }
    
    int numeroElementos(){
        return elementos.length;
    }
    
    boolean insertar(Integer nuevo){
        boolean sp=false;
        
        if(pertenece(nuevo)){
            pertenece(nuevo);
        }
        
        else{
            elementos=Arrays.copyOf(elementos, elementos.length+1);
            elementos[elementos.length-1]=nuevo;
            sp=true;
        }   
        return sp;
    }
    
    boolean insertar(Conjunto otro){
        boolean sp=true;
        boolean inser;
        
        for(int i=0;i<otro.elementos.length;i++){
           inser=insertar(otro.elementos[i]);
           if(!inser){
               sp=false;
           }
        }
        
        return sp;
    }
    
    boolean pertenece(Integer elemento){
        boolean sp=false;
        
        for(int i=0;i<elementos.length;i++){
            if(elemento==elementos[i]){
                System.out.println("Ese número existe en el conjunto");
                sp=true;
            }
            else{
                System.out.println("Ese elemento no existe en el conjunto");
                
            }
        }
        
        return sp;
    }
    
    boolean eliminar(Integer elemento){
        boolean sp=true;
        int posicion;
        Integer a1[],a2[];
                          
        if(pertenece(elemento)){
            posicion=Arrays.asList(elementos).indexOf(elemento);
            if(posicion!=elementos.length-1){
                elementos[posicion]=elementos[elementos.length-1];
                elementos=Arrays.copyOf(elementos, elementos.length-1);
            }
            else{
                elementos=Arrays.copyOf(elementos,elementos.length-1);
            }
        }
        else{
            pertenece(elemento);
            sp=false;
        }
        
        return sp;
    }
    
    boolean eliminar(Conjunto otro){
        boolean sp=false,del;
        
        for(int i=0;i<otro.elementos.length;i++){
            del=eliminar(otro.elementos[i]);
            if(del){
                sp=true;
            }            
        }
        
        return sp;
    }
    
    void mostrar(){
        System.out.println(Arrays.deepToString(elementos));
    }
    
    static boolean incluido(Conjunto c1, Conjunto c2){
        boolean sp=true;
        
        for(int i=0;i<c1.elementos.length;i++){
            if(!c2.pertenece(c1.elementos[i])){
                sp=false;
            }
            
        }
        
        return sp;
    }
    
    static Conjunto union(Conjunto c1,Conjunto c2){
        Conjunto union=new Conjunto();
        
        union.insertar(c1);
        union.insertar(c2);
        
        return union;
    }
    
    static Conjunto interseccion(Conjunto c1, Conjunto c2){
        Conjunto interseccion=new Conjunto();
        
        for(int i=0;i<c1.elementos.length;i++){
            if(c2.pertenece(c1.elementos[i])){
                interseccion.elementos=Arrays.copyOf(interseccion.elementos, interseccion.elementos.length+1);
                interseccion.elementos[interseccion.elementos.length-1]=c1.elementos[i];
            }
        }
        
        return interseccion;
    }
    
    static Conjunto diferencia(Conjunto c1, Conjunto c2){
        Conjunto diferencia=new Conjunto();
        
        diferencia.elementos=Arrays.copyOf(c1.elementos,c1.elementos.length);
        diferencia.eliminar(c2);
        
        
        return diferencia;
    }
    
    static Conjunto diferenciaS(Conjunto c1, Conjunto c2){
        Conjunto diferenciaS=new Conjunto();
        
        for(int i=0;i<c2.elementos.length;i++){
            if(!c1.pertenece(c2.elementos[i])){
                diferenciaS.elementos=Arrays.copyOf(diferenciaS.elementos, diferenciaS.elementos.length+1);
                diferenciaS.elementos[diferenciaS.elementos.length-1]=c2.elementos[i];
            }
        }
        
        
                
        return diferenciaS;
    }
    
}
