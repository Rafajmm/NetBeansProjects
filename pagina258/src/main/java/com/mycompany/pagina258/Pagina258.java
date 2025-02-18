/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pagina258;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Pagina258 {
    
    public static void mezclarE(Empleado array[]){
        int index;
        Empleado ex;
        Random r=new Random();
        for(int i=0;i<array.length;i++){
            index=r.nextInt(i+1);
            ex=array[i];
            array[i]=array[index];
            array[index]=ex;
        }
    }
    
    public static void main(String[] args) {
        
        Empleado e1=new Empleado();
        Persona p1=e1;
        Empleado e2=new Empleado("pepe",30,1.7,1950,"l");
        Empleado e3=new Empleado("pepa",30,1.7,1900,"l");
        
        System.out.println(p1.estatura);
        p1.mostrar();
        Empleado a[]=new Empleado[]{e1,e2,e3};
        
        System.out.println("-----------------------------------");
        
        System.out.println(e1.compareTo(e3));
        System.out.println(e2.compareTo(e3));
        System.out.println(e1.compareTo(e2));
        
        System.out.println("----------------------------------");
        
        Arrays.sort(a);
        System.out.println(Arrays.deepToString(a));
        
        System.out.println("---------------------------------");
        mezclarE(a);
        System.out.println(Arrays.deepToString(a));
        
        System.out.println("--------------------------------");
        
        CompararS c=new CompararS();
        System.out.println(c.compare(e1, e2));
        
        System.out.println("-------------------------------");
        
        Arrays.sort(a,c);
        System.out.println(Arrays.deepToString(a));
        
        
    }
}
