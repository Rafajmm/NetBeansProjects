package com.mycompany.problema3;
import java.util.*;
/**
 *
 * @author rafa
 */
public class Vagon {
    private int numAsientos=40;
    private TreeMap<Integer,Boolean> asientos=new TreeMap<>();
    private boolean tipo;
    
    Vagon(boolean tipo){
        setTipo(tipo);
        for(int i=1;i<=numAsientos;i++){
            asientos.put(i, false);
        }
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public TreeMap<Integer, Boolean> getAsientos() {
        return asientos;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public void setAsientos(TreeMap<Integer, Boolean> asientos) {
        this.asientos = asientos;
    }

    public void setTipo(boolean clase) {
        this.tipo = clase;
    }
    
    public void llenarVagon(){
        if(this.getTipo()){
            for(int i=1;i<=numAsientos;i++){
                if((int)(Math.random()*100)<=10){
                    asientos.replace(i, true);
                }
            }
        }
        else{
            for(int i=1;i<=numAsientos;i++){
                if((int)(Math.random()*100)<=40){
                    asientos.replace(i, true);
                }
            }
        }        
    }
    
    public String comprobarAsiento(Integer num){
        if(num>0 && num<=numAsientos){
            if(asientos.get(num)){
                return "Ocupado";
            }
            else{
                return "Disponible";
            }
        }
        else{
            return "Error: Asiento no encontrado.";
        }
    }
    
    public void actualizar(Integer num,Boolean est){
        if(num>0 && num<=numAsientos){
            asientos.replace(num, est);
        }
        else{
            System.out.println("Error: Asiento no encontrado.");
        }
    }

    @Override
    public String toString() {
        String t=tipo ? "Primera Clase":"Turista";
        
        return "Vagon{"  + ", tipo=" + t + ", asientos=" + asientos + '}';
    }
    
    public int contarOcupados(){
        int total=0;
        for(boolean asiento: asientos.values()){
            if(asiento){
                total++;
            }
        }
        return total;
    }
    
}
