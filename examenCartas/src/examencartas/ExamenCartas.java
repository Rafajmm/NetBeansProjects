/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examencartas;
import java.util.*;
/**
 *
 * @author usuario
 */
public class ExamenCartas {

    /**
     * @param args the command line arguments
     */
    public static Mano jugar(Baraja una){
        ArrayList<Carta> mano= new ArrayList<>(),mano1= new ArrayList<>();
        ComparaP ord=new ComparaP();
        
        for(int i=0;i<5;i++){
            mano.add(una.robar());
            mano1.add(una.robar());
        }
        
        Mano j1=new Mano(mano),j2=new Mano(mano1);
        
//        System.out.println("----------------------------------------------------------------------------------------");
//        System.out.println(j1);
//        System.out.println(j2);
//        System.out.println("----------------------------------------------------------------------------------------");
        
        if(j1.compareTo(j2)!=0){
            if(j1.compareTo(j2)>0){
                Collections.sort(j1.getBaraja(), ord);
                return j1;
            }
            else{
                Collections.sort(j2.getBaraja(), ord);
                return j2;
            }
        }
        else{
            System.out.println("Han empatado");
            return j1;
        }
         
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Baraja una=new Baraja();                     
        
        
        System.out.println(jugar(una));
        
        
        System.out.println("-----------------------------------------");
        
        
    }
    
}
