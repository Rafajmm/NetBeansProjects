/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problema4;
import java.util.*;
/**
 *
 * @author rafa
 */
public class Candado{
    private ArrayList<Integer> comb=new ArrayList<>();
    private ArrayList<Integer> estado=new ArrayList<>(Arrays.asList(0,0,0));
    
    Candado(ArrayList<Integer> nums){
        comb.addAll(nums);        
    }

    public ArrayList<Integer> getComb() {
        return comb;
    }

    public void setComb(ArrayList<Integer> comb) {
        this.comb = comb;
    }

    public ArrayList<Integer> getEstado() {
        return estado;
    }

    public void setEstado(ArrayList<Integer> estado) {
        this.estado = estado;
    }
    
    public void cambiarNumero(int pos, int nuevo){
        if(pos>0 && pos<=estado.size()){
            estado.set(pos-1, nuevo);
        }
        else{
            System.out.println("Posicion invalida. Debe estar entre 1 y 3");
        }
    }
    
    public boolean puedeAbrir(){
        if(comb.equals(estado)) return true;
        else return false;               
    }

    
    public boolean mismaCombinacion(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candado other = (Candado) obj;     
        return Objects.equals(this.comb, other.comb);
    }

    
    
    
}
