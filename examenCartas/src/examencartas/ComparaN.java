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
public class ComparaN implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        Carta una=(Carta)uno, otra=(Carta)otro;
        return una.getNumero()-otra.getNumero();
    }
    
}
