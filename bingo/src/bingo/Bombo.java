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
public class Bombo {
    private ArrayList<Integer> bomb=new ArrayList<>();
    
    Bombo(){
        HashSet<Integer> nums=new HashSet<>();
        for(int i=1;i<100;i++){
            nums.add(i);
        }
        bomb.addAll(nums);
        Collections.shuffle(bomb);        
    }

    public ArrayList<Integer> getBomb() {
        return bomb;
    }

    public void setBomb(ArrayList<Integer> bomb) {
        this.bomb = bomb;
    }
    
    
    
    public int extraer(){
        int n=0;
        n=bomb.get(0);
        bomb.remove(0);
        
        return n;
    }

    @Override
    public String toString() {
        return "Bombo{" + "numeros=" + bomb + '}';
    }
    
    
}
