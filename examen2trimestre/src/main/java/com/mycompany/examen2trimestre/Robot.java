/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen2trimestre;

/**
 *
 * @author usuario
 */
public class Robot {
    private String nombre;
    private double cargaA;
    private double cargaM;
    private int año;
    private double pasos;
    
    Robot(){
        nombre="robot";
        cargaA=0;
        cargaM=40;
        año=2015;
        pasos=0;
    }
    Robot(String nombre,double cargaA,double cargaM,int año, double pasos){
        setNombre(nombre);
        setCargaA(cargaA);
        setCargaM(cargaM);
        setAño(año);
        setPasos(pasos);
    }
    Robot(String nombre){
        this();
        setNombre(nombre);
    }
    
    @Override
    public String toString(){
        String cadena;
        cadena="Robot: "+getNombre()+" carga actual: "+getCargaA()+" carga máxima: "+getCargaM()+" año: "+getAño()+" pasos: "+getPasos();
        return cadena;
    }
    
    @Override
    public boolean equals(Object otro){
        boolean igual;
        Robot otroRobot=(Robot) otro;
        
       if(this.nombre.equals(otroRobot.getNombre()) && this.cargaA==otroRobot.getCargaA() && this.cargaM==otroRobot.getCargaM() && this.año==otroRobot.getAño() && this.pasos==otroRobot.getPasos()){
           igual=true;
       }
       else{
           igual=false;
       }
        
        return igual;
    }
    
    void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    void setCargaA(double cargaA){
        if(cargaA>=0){
            this.cargaA=cargaA;
        }
        else{
            this.cargaA=0;
            System.out.println("Valor introducido no válido. Introducido valor por defecto (0)");
        }
    }
    
    void setCargaM(double cargaM){
        if(cargaM<41){
            this.cargaM=cargaM;
        }
        else{
            this.cargaM=40;
            System.out.println("Valor introducido no válido. Introducido valor por defecto (40)");
        }            
    }
    
    void setAño(int año){
        if(año<2026 && año>1999){
            this.año=año;
        }
        else{
            this.año=2015;
            System.out.println("Valor introducido no válido. Introducido valor por defecto (2015)");
        } 
    }
    
    void setPasos(double pasos){
        if(pasos>=0){
            this.pasos=pasos;
        }
        else{
            this.pasos=0;
            System.out.println("Valor introducido no válido. Introducido valor por defecto (0)");
        } 
    }
    
    
    String getNombre(){
        return this.nombre;        
    }
    
    double getCargaA(){
        return this.cargaA;
    }
    
    double getCargaM(){
        return this.cargaM;
    }
    
    int getAño(){
        return this.año;
    }
    
    double getPasos(){
        return this.pasos;
    }
    
    
    void mostrar(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Carga actual: "+getCargaA());
        System.out.println("Carga máxima: "+getCargaM());
        System.out.println("Año de fabricación: "+getAño());
        System.out.println("Distancia recorrida: "+getPasos());
    }
    
    
    double mover(){
        this.pasos+=((1.1-(cargaA/cargaM))*10);
        return getPasos();
    }
    
    
}
