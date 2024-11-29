package com.mycompany.actividad514;
import java.util.*;

public class Actividad514 {
    
    public static double[] ordenar(double sueldos[]){
        Arrays.sort(sueldos);
        double s2[]=new double[sueldos.length];
        for(int i=0;i<sueldos.length;i++){
            s2[i]=sueldos[sueldos.length-1-i];
        }
        return s2;
    }
    
    public static double media(double sueldos[]){
        double suma=0;
        for(int i=0;i<sueldos.length;i++){
            suma+=sueldos[i];
        }
        suma/=sueldos.length;
        return suma;
    }
    
    public static void main(String[] args) {
        double sueldos[]=new double[0];
        Scanner leer=new Scanner(System.in);
        double n=0;
        while(n!=-1){
            System.out.println("Introduce sueldos: ");
            n=leer.nextDouble();
            if(n!=-1){
                sueldos=Arrays.copyOf(sueldos, sueldos.length+1);
                sueldos[sueldos.length-1]=n;
            }
        }
        
        System.out.println(Arrays.toString(ordenar(sueldos)));
        System.out.println("El sueldo más alto es "+ordenar(sueldos)[0]);
        System.out.println("El sueldo más bajo es: "+ordenar(sueldos)[sueldos.length-1]);
        System.out.println("La media es "+media(sueldos));
        
    }
    
}
