/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1208;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Decreciente implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        return (Integer)otro-(Integer)uno;
    }
}
