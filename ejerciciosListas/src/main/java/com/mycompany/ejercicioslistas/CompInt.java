/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioslistas;

import java.util.Comparator;

/**
 *
 * @author usuario
 */
public class CompInt implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        
            return (Integer)uno-(Integer)otro;
    }
}
