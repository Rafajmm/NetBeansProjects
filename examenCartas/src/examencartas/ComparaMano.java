/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examencartas;

import java.util.Comparator;

/**
 *
 * @author usuario
 */
public class ComparaMano implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Mano una=(Mano)o1,otra=(Mano)o2;
        int n=0,n1=0;
        for(Carta carta: una.getBaraja()){
            n+=carta.getNumero();
        }
        for(Carta carta: otra.getBaraja()){
            n1+=carta.getNumero();
        }
        return n-n1;
    }
    
    
}
