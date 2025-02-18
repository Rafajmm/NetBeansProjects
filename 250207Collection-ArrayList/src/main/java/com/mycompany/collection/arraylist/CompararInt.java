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
public class CompararInt implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        
            return (Integer)uno-(Integer)otro;
    }    
}
