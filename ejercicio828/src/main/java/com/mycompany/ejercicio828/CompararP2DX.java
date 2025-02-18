/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio828;
import java.util.*;

/**
 *
 * @author usuario
 */
public class CompararP2DX implements Comparator{
    public int compare(Object uno, Object otro){
        Punto2D unoP=(Punto2D) uno, otroP=(Punto2D) otro;
        return (int) (unoP.x-otroP.x);
    }
}
