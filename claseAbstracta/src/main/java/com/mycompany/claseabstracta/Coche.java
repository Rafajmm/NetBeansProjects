package com.mycompany.claseabstracta;

public class Coche extends Vehiculo{
    protected int potencia;
    
    Coche(){
        super();
        potencia=0;
    }
    
    Coche(int peso, double maxComb, int[] color, double maxCarga,double autonomia,int potencia){
        super(peso,maxComb,color,maxCarga,autonomia);
        this.potencia=potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }            
}
