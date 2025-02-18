package com.mycompany.claseabstracta;

public class Avion extends Vehiculo{
    private double envergadura;
    
    Avion(){
        super();
        envergadura=0;
    }
    Avion(int peso, double maxComb, int[] color, double maxCarga,double autonomia,double envergadura){
        super(peso,maxComb,color,maxCarga,autonomia);
        this.envergadura=envergadura;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }

    @Override
    void setAutonomia(double autonomia) {
        this.autonomia = autonomia*0.6;
    }
    
    
}
