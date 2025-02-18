package com.mycompany.ejercicio81;

public class Hora {
    protected int hora;
    protected int minuto;
    
    Hora(int hora, int minuto){
        setHora(hora);
        setMinuto(minuto);
    }
    
    Hora(){
        setHora(0);
        setMinuto(0);
    }

    public boolean setHora(int hora) {
        boolean posible;
        if(hora>=0 && hora<24){
            this.hora = hora;
            posible=true;
        }
        else{
            this.hora=12;
            System.out.println("Valor no válido. Valor por defecto '0'");
            posible=false;
        }
        return posible;
    }
    
    public boolean setMinuto(int minuto) {
        boolean posible;
        if(minuto>=0 && minuto<60){
            this.minuto = minuto;
            posible=true;
        }
        else{
            this.minuto=0;
            System.out.println("Valor no válido. Valor por defecto '0'");
            posible=false;
        }
        
        return posible;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }
    
    void inc(){
        if(minuto==59){
            minuto=0;
            if(hora==23){
                hora=0;
            }
            else{
                hora+=1;
            }
        }
        else{
            minuto+=1;
        }
    }

    @Override
    public String toString() {
        return "Hora{" + "hora=" + hora + ", minuto=" + minuto + '}';
    }

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
        final Hora other = (Hora) obj;
        if (this.hora != other.hora) {
            return false;
        }
        return this.minuto == other.minuto;
    }
    
    
}
