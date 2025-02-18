package com.mycompany.herenciamultiple;
import java.util.*;

public class Figura {
    protected double base;
    protected double altura;
    protected double radio;
    protected double radioM;
    protected double x[];
    protected double y[];
    protected int color[];
    
    Figura(){
        base=0;
        altura=0;
        radio=0;
        radioM=0;
        x=new double[2];
        y=new double[2];
        color=new int[]{255,0,0};
    }

    Figura(double base, double altura, double radio, double radioM, double[] x, double[] y, int[] color) {
        this.base = base;
        this.altura = altura;
        this.radio = radio;
        this.radioM = radioM;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getRadio() {
        return radio;
    }

    public double getRadioM() {
        return radioM;
    }

    public double[] getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public int[] getColor() {
        return color;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setRadioM(double radioM) {
        this.radioM = radioM;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public void setY(double[] y) {
        this.y = y;
    }

    public void setColor(int color[]) {
        this.color = color;
    }
    
    void mostrar(){
        System.out.println("base: "+base+" altura: "+altura+" radio: "+radio+" radioMayor: "+radioM+" x: "+Arrays.toString(x)+" y: "+Arrays.toString(y)+" color: "+Arrays.toString(color));
    }
    void dibujar(){}
}
