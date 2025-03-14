/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingo;

import java.util.*;

/**
 *
 * @author usuario
 */
public class Bingo {

    /**
     * @param args the command line arguments
     */
    public static Carton jugar(Bombo uno, Carton siete[]){
        TreeSet<Integer> comprobar=new TreeSet<>();
        Carton ganador=new Carton();
        boolean parar=false;
        while(!parar){
            int num=uno.extraer();
            comprobar.add(num);
            for(int i=0;i<siete.length;i++){
                siete[i].comprobarN(num);
                if(Carton.comprobarB(siete[i])){
                    parar=true;
                    
                    
                }
            }
        }
        
        return ganador;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Bombo uno=new Bombo();
        Carton siete[]=new Carton[7];        
        
        for(int i=0;i<7;i++){
            siete[i]=new Carton();
        }
        System.out.println(uno.getBomb());
        System.out.println(Arrays.toString(siete));
        
        
        
        System.out.println(jugar(uno,siete).getConjunto());
        
    }
    
}
