package com.mycompany.pokemonjava;
import java.util.*;

public class Pichu extends Pokemon{
    
    Pichu(String entrenador, int experiencia, int salud){
        super(entrenador,experiencia,salud);
        setExperiencia(experiencia);
        setSalud(salud);
        this.experienciaMax=50;
    }
    Pichu(){
        
    }

    @Override
    void setExperiencia(int experiencia) {
        if(experiencia>=15){
            this.experiencia = experiencia;
        }
        else{
            System.out.println("Experiencia no válida. Establecida por defecto (15)");
            this.experiencia=15;
        }
        
    }

    @Override
    void setSalud(int salud) {
        if(salud>=50){
            this.salud = salud;
        }
        else{
            System.out.println("Salud no válida. Establecida salud por defecto (50)");
            this.salud=50;
        }
    }
    
    @Override
    int ataqueRapido(){
        int ataque;
        if(Math.random()<0.5){
            ataque=10;
        }
        else{
            ataque=20;
        }
        return ataque;
    }
    
    int bolaRayo(){
        return (int)((Math.random()*11)+10);
    }
    
    
    
}
