package com.mycompany.ejercicio715;


public class Calendario {
    private int año;
    private int mes;
    private int dia;
    
    Calendario(int dia, int mes, int año){
        setDia(dia);
        setMes(mes);
        setAño(año);
    }
    Calendario(){
        this.dia=1;
        this.mes=1;
        this.año=2000;
    }
    
    void incrementarDia(){
        if((dia+1)<30){
            dia+=1;
        }
        else{
            dia=1;
            incrementarMes();
        }
    }
    
    void incrementarMes(){
        if((mes+1)<12){
            mes+=1;
        }
        else{
            mes=1;
            incrementarAño();
        }        
    }
    
    void incrementarAño(){
        año+=1;
    }
    
    void mostrar(){
        System.out.println("Fecha-> "+dia+":"+mes+":"+año);
    }
    
    boolean iguales(Calendario otro){
        boolean si=false;
        if(dia==otro.dia && mes==otro.mes && año==otro.año){
            si=true;
        }
        return si;
    }
    
    void setDia(int dia){
        if(dia>0 && dia<31){
            this.dia=dia;
        }
        else{
            System.out.println("Dia no válido. Valor por defecto establecido (1)");
            this.dia=1;
        }
    }
    
    void setMes(int mes){
        if(mes>0 && mes<13){
            this.mes=mes;
        }
        else{
            System.out.println("Mes no válido. Valor por defecto establecido (1)");
            this.mes=1;
        }
    }
    
    void setAño(int año){
        if(año>0){
            this.año=año;
        }
        else{
            System.out.println("Año no válido. Valor por defecto establecido (1)");
            this.año=200;
        }
    }
    
    int getDia(){
        return dia;
    }
    
    int getMes(){
        return mes;
    }
    
    int getAño(){
        return año;
    }
}
