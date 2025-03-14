/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.*;

/**
 *
 * @author usuario
 */
public class Carton {
    private HashSet<Integer> conjunto=new HashSet<>();
    
    Carton(){
        while(conjunto.size()<15){
            conjunto.add((int)(Math.random()*99+1));
        }
    }

    public HashSet<Integer> getConjunto() {
        return conjunto;
    }

    public void setConjunto(HashSet<Integer> conjunto) {
        this.conjunto = conjunto;
    }
    
    public void comprobarN(int n){
        if(conjunto.contains(n)){
            conjunto.remove(n);
        }        
    }
    
    public static boolean comprobarB(Carton uno){
        if(uno.getConjunto().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Carton{" + "conjunto=" + conjunto + '}';
    }
    
    
    
}
