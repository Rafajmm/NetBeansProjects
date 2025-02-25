/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciosconjuntos;
import java.util.*;
/**
 *
 * @author usuario
 */
public class EjerciciosConjuntos {

    public static void main(String[] args) {
        System.out.println("---------------------------------------Ejercicio1------------------------------------------------------");
        /*
        int contador=0;
        Scanner teclado=new Scanner(System.in);
        TreeSet<String> palabras=new TreeSet<>();
        
        System.out.println("Introduce palabras");
        while(contador<10){
            System.out.println("");
            String palabra=teclado.next();
            palabras.add(palabra);
            contador++;
        }
        
        for(String palabra: palabras){
            System.out.println(palabra);
        }
        */
        
        System.out.println("---------------------------------------Ejercicio2------------------------------------------------------");
        
        ArrayList<Integer> numAl=new ArrayList<>();
        TreeSet<Integer> numO=new TreeSet<>();
        int alea;
        
        while(numO.size()<50){
            alea=(int)((Math.random()*100)+1);
                
                numO.add(alea);
            
        }
        
        System.out.println(numO);
        
        
        for(int i=1;i<101;i++){
            if(!numO.contains(i)){
                numAl.add(i);
            }
        }
        
        System.out.println(numAl);
    }
}
