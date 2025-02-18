package com.mycompany.pokemonjava;
import java.util.*;

abstract class Pokemon {
    
    protected String entrenador;
    protected int experiencia;
    protected int salud;
    protected int experienciaMax;
    
    Pokemon(){
        entrenador="nombre";
        experiencia=0;
        salud=0;
        experienciaMax=0;
    }
    Pokemon(String entrenador, int experiencia, int salud) {
        
        this.entrenador = entrenador;
        this.experiencia = experiencia;
        this.salud = salud;
    }

    

    public String getEntrenador() {
        return entrenador;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getSalud() {
        return salud;
    }
    
    public int getExperienciaMax() {
        return experienciaMax;
    }
    

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    abstract void setExperiencia(int experiencia);

    abstract void setSalud(int salud);

    
    public String mostrar() {
        return "entrenador=" + entrenador + ", experiencia=" + experiencia + ", salud=" + salud + '}';
    }
    
    abstract int ataqueRapido();

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        if (this.experiencia != other.experiencia) {
            return false;
        }
        if (this.salud != other.salud) {
            return false;
        }
        if (this.experienciaMax != other.experienciaMax) {
            return false;
        }
        return Objects.equals(this.entrenador, other.entrenador);
    }
    
    
}
