/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1205;
import java.util.*;
/**
 *
 * @author usuario
 */
public class CompNombre implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        return ((Cliente)uno).getNombre().compareToIgnoreCase(((Cliente)otro).getNombre());
    }
    
}
