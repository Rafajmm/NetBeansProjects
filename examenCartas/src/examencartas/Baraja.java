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
public class Baraja {
    protected ArrayList<Carta> baraja=new ArrayList<>();

    public Baraja() {
        
        for(int i=1;i<49;i++){
            if(i<13){                
                baraja.add(new Carta(i,"Oros"));
            }            
            else if(i<25){                
                baraja.add(new Carta(i-12,"Copas"));                
            }
            else if(i<37){
                baraja.add(new Carta(i-24,"Espadas"));
            }
            else if(i<49){
                baraja.add(new Carta(i-36,"Bastos"));
            }
        }
    }
    
    Baraja(Carta iniciales[]){
        ArrayList<Carta> ini=new ArrayList<>(Arrays.asList(iniciales));
        baraja.addAll(ini);
    }
    
    Baraja(ArrayList<Carta> iniciales){
        baraja.addAll(iniciales);
    }

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }
    
    
    
    public Carta robar(){
        mezclar();
        Carta una=baraja.get(0);
        baraja.remove(0);
        return una;
    }
    
    public void mezclar(){
        Collections.shuffle(baraja);
    }
    public void barajar(){
        mezclar();
    }
    
    public boolean vacia(){
        return baraja.isEmpty();            
    }
    
    
    
    @Override
    public String toString() {
        return "baraja=" + baraja;
    }
    
    
}
