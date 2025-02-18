/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.collection.arraylist;
import java.util.*;
/**
 *
 * @author usuario
 */
public class CompararE implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        if(((Futbolista)uno).getEdad()-((Futbolista)otro).getEdad()==0){
            return ((Futbolista)uno).getNombre().compareToIgnoreCase(((Futbolista)otro).getNombre());
        }
        else{
            return ((Futbolista)uno).getEdad()-((Futbolista)otro).getEdad();
        }
        
    }
}
