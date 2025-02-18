package com.mycompany.claseabstracta;

public class Suv extends Coche{
    protected double pulgadas;
    
    Suv(){
        super();
        pulgadas=0;
    }
    
    Suv(int peso, double maxComb, int[] color, double maxCarga,double autonomia,int potencia,double pulgadas){
        super(peso,maxComb,color,maxCarga,autonomia,potencia);
        this.pulgadas=pulgadas;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }       
}
