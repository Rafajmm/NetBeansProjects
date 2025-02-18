package com.mycompany.ejercicio828;

public class Ejercicio828 {

    public static void main(String[] args) {
        Suceso s=new Suceso(1.1,2.2,3.3,5,"Primer suceso");
        Suceso s2=new Suceso(1.1,2.2,3.3,5,"Primer suceso");
        Suceso s3=new Suceso(1.1,2.2,3.3,5,"Primer suceso1");
        Suceso s4=new Suceso(1.5,2.2,3.3,5,"Primer suceso");
        
        System.out.println(s.equals(s4));
        System.out.println(s.equals(s3));
        System.out.println(s.equals(s2));
        
        Punto2D p1=new Punto2D(1,3);
        Punto2D p2=new Punto2D(3,1);
        Punto2D p3=new Punto2D(1,0);
        Punto2D p4[]={p1,p2,p3};
        
        System.out.println( p1.compareTo(p3));
        System.out.println(p1.compareTo(p2));
        System.out.println(p2.compareTo(p1));
        
        
        
        CompararP2DX comp= new CompararP2DX();
        System.out.println(comp.compare(p1, p2));
        
    
    }
}
