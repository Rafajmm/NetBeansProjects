/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.collection.arraylist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author usuario
 */
public class App {

    public static void main(String[] args) {
        
        Futbolista f1=new Futbolista("45454545A","pepe",30,7);
        Futbolista f2=new Futbolista("92929292S","pepa",25,19);
        Futbolista f3=new Futbolista("14141414D","luis",19,0);
        Futbolista f4=new Futbolista("06060606F","luisa",30,2);
        Futbolista f5=new Futbolista("93939393G","messi",39,100);
        
        Futbolista fT[]=new Futbolista[]{f1,f2,f3,f4,f5};
        
        List<Futbolista> fut;
        fut=new ArrayList<>();
        
        fut.add(f5);
        System.out.println(fut.size());
        System.out.println(fut.toString());
        System.out.println(fut.toArray());
        System.out.println(f5.toString());
        
        System.out.println("--------------------------------------------------------");
        f5.setNombre("Ronaldo");
        
        System.out.println(f5.toString());
        System.out.println(fut.toString());
        
        System.out.println("--------------------------------------------------------");
        
        
        fut.set(0, f1);
        fut.add(0,f2);
        System.out.println(fut.size());
        System.out.println(fut.toString());
        
        System.out.println("--------------------------------------------------------");
        
        fut.add(2,f3);
        System.out.println(fut.size());
        System.out.println(fut.toString());
        
        System.out.println("--------------------------------------------------------");
        
        fut.add(3,f4);
        ComparaN cn= new ComparaN();
        CompararE ce=new CompararE();
        
        System.out.println(fut.size());
        fut.sort(cn);
        System.out.println(fut.toString());
        
        System.out.println("----------------------------------------------------------");
        fut.sort(ce);
        System.out.println(fut.toString());
    
    
        ArrayList<Integer> primitiva=new ArrayList<>();
        
        
        
        int temp;
        while(primitiva.size()<6){
            temp=(int)((Math.random()*49)+1);
            if(!primitiva.contains(temp)){
                primitiva.add(temp);
            }
        }
        
        System.out.println(primitiva.toArray());
        System.out.println(primitiva.toString());
        for(Integer numero : primitiva){
            System.out.println(numero);
        }
        
        System.out.println("-----------------------------------------------------------");
        
        primitiva.sort(new CompararInt());        
        System.out.println(primitiva.toString());
        
        System.out.println("-----------------------------------------------------------");
        
        Collections.shuffle(primitiva);
        System.out.println(primitiva.toString());
        
        System.out.println("-----------------------------------------------------------");
        
        Collections.sort(primitiva);
        System.out.println(primitiva.toString());
        
        System.out.println("-----------------------------------------------------------");
        
        Collections.reverse(primitiva);
        System.out.println(primitiva.toString());
        
        System.out.println("-----------------------------------------------------------");
        
        
    }
}
