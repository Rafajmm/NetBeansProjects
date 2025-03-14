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
public class Carta implements Comparable{
    private int numero;
    private String palo;
    private ArrayList<String> ps=new ArrayList<>(Arrays.asList("Oros","Copas","Espadas","Bastos"));

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
        return numero + " de " + palo;
    }
    
    @Override
    public int compareTo(Object otro){
        Carta otra=(Carta) otro;
        return this.getNumero()-otra.getNumero();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        return Objects.equals(this.palo, other.palo);
    }
    
    
}
