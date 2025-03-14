/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencartas;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Mano extends Baraja implements Comparable{
    Mano(ArrayList<Carta> cinco){
        super(cinco);
    }
    Mano(){
        super();
        this.baraja.removeAll(baraja);
    }
    @Override
    public int compareTo(Object o){
        Mano otra=(Mano)o;
        int n=0,n1=0;
        for(Carta carta: this.baraja){
            n+=carta.getNumero();
        }
        for(Carta carta: otra.getBaraja()){
            n1+=carta.getNumero();
        }
        return n-n1;
    }

    
}
