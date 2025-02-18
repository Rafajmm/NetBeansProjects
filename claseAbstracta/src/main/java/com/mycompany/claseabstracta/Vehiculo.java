package com.mycompany.claseabstracta;

abstract class Vehiculo {
    protected int peso;
    protected double maxComb;
    protected int[] color;
    protected double maxCarga;
    protected double autonomia;
    Vehiculo(){
        peso=0;
        maxComb=0;
        color=new int[]{255,0,0};
        maxCarga=0;
        autonomia=0;
    }
    Vehiculo(int peso, double maxComb, int[] color, double maxCarga,double autonomia){
        this.peso=peso;
        this.maxComb=maxComb;
        this.color=color;
        this.maxCarga=maxCarga;
        this.autonomia=autonomia;
    }

    public int getPeso(){
         return peso;
     }

    public double getMaxComb() {
        return maxComb;
    }

    public int[] getColor() {
        return color;
    }

    public double getMaxCarga() {
        return maxCarga;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setMaxComb(double maxComb) {
        this.maxComb = maxComb;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public void setMaxCarga(double maxCarga) {
        this.maxCarga = maxCarga;
    }
    
    abstract void setAutonomia(double autonomia);
}
