/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioslistas;

import java.util.*;

/**
 *
 * @author usuario
 */
public class Carta {
    private int numero;
    private String palo;
    private ArrayList<String> ps=new ArrayList<>(Arrays.asList("Oro","Copa","Espada","Basto"));

    public Carta(int numero, String palo) {
        setNumero(numero);
        setPalo(palo);        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero>=1 && numero<=12){
            this.numero = numero;
        }
        else{
            System.out.println("Número no válido");
        } 
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        if(ps.contains(palo)){
            this.palo = palo;        
        }
        else{
            System.out.println("No has introducido un palo. (Oro,Copa,Espada,Basto)");
        }
    }

    @Override
    public String toString() {
        return numero + "de" + palo;
    }
    
    
}
