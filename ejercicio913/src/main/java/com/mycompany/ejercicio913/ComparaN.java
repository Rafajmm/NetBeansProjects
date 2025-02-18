/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio913;
import java.util.*;
/**
 *
 * @author usuario
 */
public class ComparaN implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        return ((Futbolista)uno).getNombre().compareToIgnoreCase(((Futbolista)otro).getNombre());
    }
    
}
