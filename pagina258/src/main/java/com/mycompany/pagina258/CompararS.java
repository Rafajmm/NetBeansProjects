/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagina258;
import java.util.*;
/**
 *
 * @author usuario
 */
public class CompararS implements Comparator{
    @Override
    public int compare(Object uno, Object otro){
        return ((Empleado)uno).getSalario()-((Empleado)otro).getSalario();
    }
}
