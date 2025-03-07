/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio1205;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Ejercicio1205 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CompEdad uno=new CompEdad();
        CompNombre otro=new CompNombre();
        HashSet<Cliente> conjuntoC=new HashSet<>();
        TreeSet<Cliente> ordenadoE=new TreeSet<>(uno);
        TreeSet<Cliente> ordenadoN=new TreeSet<>(otro);
        
        for(int i=0;i<20;i++){
            conjuntoC.add(new Cliente("454512"+i,"Nombre"+i,25+i));            
        }
        System.out.println(conjuntoC);
        for(Cliente c: conjuntoC){
            ordenadoE.add(c);
            ordenadoN.add(c);
        }
        
        System.out.println(ordenadoE);
        System.out.println(ordenadoN);
    }
}
