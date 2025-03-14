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
public class BarajaSimple extends Baraja{

    public BarajaSimple() {
        super();
        Iterator<Carta> itr=baraja.iterator();
        while(itr.hasNext()){
            int n=itr.next().getNumero();
            if(n==8 || n==9){
                itr.remove();
            }
        }
    }
    
}
