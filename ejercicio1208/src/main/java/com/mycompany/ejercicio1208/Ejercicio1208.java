/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1208;

import java.util.*;

/**
 *
 * @author usuario
 */
public class Ejercicio1208 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int temp=0;
        Collection lista;
        ArrayList<Integer> listaT=new ArrayList<>();
        lista=listaT;
        
        while(lista.size()<20){
            temp=(int)(Math.random()*49)+1;
            if(!lista.contains(temp)){
                lista.add(temp);
            }
        }
        
        
        Integer[] tabla=(Integer[])lista.toArray(new Integer[0]);
        Arrays.sort(tabla);                       
        System.out.println(Arrays.toString(tabla));
        
        System.out.println("----------------------------------------------------------------");
       
        Arrays.sort(tabla, new Decreciente());
        System.out.println(Arrays.toString(tabla));
        
        System.out.println("----------------------------------------------------------------");
        
        int z=tabla.length-1;
        Integer inter=0;
        for(int i=0;i<tabla.length/2;i++){
            inter=tabla[z];
            tabla[z]=tabla[i];
            tabla[i]=inter;            
            z--;
        }        
        System.out.println(Arrays.toString(tabla));
        
        System.out.println("----------------------------------------------------------------");
        
        ArrayList<Integer> otraLista=new ArrayList<>();
        otraLista.addAll(Arrays.asList(tabla));
        
        Collection<Integer> nuevaColeccion=Arrays.asList(tabla);
    }
}
