/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio913;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Ejercicio913 {

    public static void main(String[] args) {
        Futbolista f1=new Futbolista("45454545A","pepe",30,7);
        Futbolista f2=new Futbolista("92929292S","pepa",25,19);
        Futbolista f3=new Futbolista("14141414D","luis",19,0);
        Futbolista f4=new Futbolista("06060606F","luisa",30,2);
        Futbolista f5=new Futbolista("93939393G","messi",39,100);
        
        Futbolista fT[]=new Futbolista[]{f1,f2,f3,f4,f5};
        
        System.out.println(f1.compareTo(f2));
        Arrays.sort(fT);
        System.out.println(Arrays.deepToString(fT));
        
        System.out.println("--------------------------------");
        
        ComparaN cn=new ComparaN();
        System.out.println(cn.compare(f1,f2));
        Arrays.sort(fT, cn);
        System.out.println(Arrays.deepToString(fT));
        
        System.out.println("---------------------------------");
        
        CompararE cE=new CompararE();
        System.out.println(cE.compare(f3, f4));
        Arrays.sort(fT,cE);
        System.out.println(Arrays.deepToString(fT));
        
        System.out.println("-------------------------------");
        
        Liga.nombreLiga();
    }
}
