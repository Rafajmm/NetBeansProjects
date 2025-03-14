/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pokemonjava;

/**
 *
 * @author usuario
 */
public class Pokemonjava {
    
//    public static void pelea(Pokemon uno){
//    
//        int daño=0,exp=0;
//        
//        while(uno.getExperiencia()<uno.getExperienciaMax()){
//            while(daño<100){
//                daño+=uno.ataqueRapido();
//                System.out.println("Daño infligido: "+daño);
//            }
//            if(daño>=100){
//                uno.setExperiencia(uno.getExperiencia()+15);
//                daño=0;
//                System.out.println(uno.getExperiencia());
//            }
//            
//        }
//    }
    
    public static void main(String[] args) {
        Pichu pichu=new Pichu("rafa",0,15);
        Pichu pichu2=new Pichu("rafa",0,15);
        int daño=0;
        
        while(pichu.getExperiencia()<50){
            while(daño<100){
                daño+=pichu.ataqueRapido();
                System.out.println("Daño infligido: "+daño);
            }
            if(daño>=100){
                pichu.setExperiencia(pichu.getExperiencia()+15);
                daño=0;
                System.out.println(pichu.getExperiencia());
            }
            if(pichu.getExperiencia()>=50){
                pichu=new Pikachu(pichu.getEntrenador(),pichu.getExperiencia(),75);
            }
        }
        System.out.println(pichu.mostrar());
        System.out.println(pichu.getClass());
        System.out.println("----------------------------------------------------------------------------------------------");
        
        while(pichu.getExperiencia()<100){
            while(daño<100){
                daño+=pichu.ataqueRapido();
                System.out.println("Daño infligido: "+daño);
            }
            if(daño>=100){
                pichu.setExperiencia(pichu.getExperiencia()+15);
                daño=0;
                System.out.println(pichu.getExperiencia());
            }
            if(pichu.getExperiencia()>=100){
                pichu=new Raichu(pichu.getEntrenador(),pichu.getExperiencia(),100);
            }
        }
        System.out.println(pichu.mostrar());
        System.out.println(pichu.getClass());
        System.out.println(pichu.equals(pichu2));
       
        
        
    }
}
