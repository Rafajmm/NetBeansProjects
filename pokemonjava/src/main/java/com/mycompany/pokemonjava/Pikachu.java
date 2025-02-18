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
public class Pikachu extends Pichu{

    Pikachu(){
        this.entrenador=super.entrenador;
        this.experiencia=super.experiencia;
        this.salud=75;
    }
    Pikachu(String entrenador,int experiencia, int salud){
        super(entrenador,experiencia,salud);
        setExperiencia(experiencia);
        setSalud(salud);
        this.experienciaMax=100;
    }

    void setExperiencia(int experiencia) {
        if(experiencia>=50){
            this.experiencia = experiencia;
        }
        else{
            System.out.println("Establecida experiencia por defecto (50)");
            this.experiencia=50;
        }
    }

    public void setSalud(int salud) {
        if(salud>=75){
            this.salud = salud;
        }
        else{
            System.out.println("Establecida salud por defecto");
            this.salud=75;
        }
    }
    
    
    int ataqueRapido(){
        int ataque;
        if(Math.random()<0.5){
            ataque=15;
        }
        else{
            ataque=25;
        }
        return ataque;
    }
    
    int bolaBoltio(){        
        return (int)((Math.random()*41)+10);
    }
    
    
}
