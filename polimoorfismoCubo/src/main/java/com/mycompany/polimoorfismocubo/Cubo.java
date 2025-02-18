package com.mycompany.polimoorfismocubo;

public class Cubo {
    protected String nombre;
    protected String textura;
    protected int experiencia;
    protected int dimensiones[];
    
    Cubo(){
        nombre="Cubo";
        textura="text";
        experiencia=10;
        dimensiones=new int[]{4,4};        
    }
    
    Cubo(String textura,int experiencia,int dimensiones[]){
        this();
        setExperiencia(experiencia);
        setDimensiones(dimensiones);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTextura() {
        return textura;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int[] getDimensiones() {
        return dimensiones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setDimensiones(int[] dimensiones) {
        this.dimensiones = dimensiones;
    }
    
    public void destruir(){
        System.out.println("Me rompí");
    }
}
