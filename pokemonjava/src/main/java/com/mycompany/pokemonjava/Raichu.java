/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemonjava;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Raichu extends Pikachu{
    
    Raichu(String entrenador, int experiencia,int salud){
        super(entrenador,experiencia,salud);
        setExperiencia(experiencia);
        setSalud(salud);
    }

    public void setExperiencia(int experiencia) {
        if(experiencia>=100){
            this.experiencia = experiencia;
        }
        else{
            System.out.println("Experiencia por defecto establecida (100)");
            this.experiencia=100;
        }
    }

    public void setSalud(int salud) {
        if(salud>=100){
            this.salud = salud;
        }
        else{
            System.out.println("Salud por defecto establecida (100)");
            this.salud=100;
        }
    }
    
    int ataqueRapido(){
        int ataque;
        if(Math.random()<0.5){
            ataque=30;
        }
        else{
            ataque=40;
        }
        return ataque;
    }
    
    int estallidoTrueno(){
        return (int)((Math.random()*81)+10);
    }
}
