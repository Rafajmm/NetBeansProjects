/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen2trimestre;
import java.util.*;
/**
 *
 * @author usuario
 */
public class Examen2trimestre {
    
    public static int oldest(Robot robot[]){
        int indice=0;
        int ant=2050;
        double carga=0;
        
        for(int i=0;i<robot.length;i++){
            if(robot[i].getAño()<ant){
                ant=robot[i].getAño();
                indice=i;
            }
            else if(robot[i].getAño()==ant){
                for(int z=0;z<robot.length;z++){
                    if(robot[z].getCargaM()>carga){
                        carga=robot[z].getCargaM();
                        indice=z;
                    }
                    else if(robot[z].getCargaM()==carga){
                        indice=z;
                    }
                }
            }
        }
        
        return indice;
    }
    
    public static int[] race(Robot robot[],int distancia){
        int turnos[]={0,0,0,0};
        
        for(int i=0;i<robot.length;i++){
            while(robot[i].getPasos()<distancia){
                robot[i].mover();
                turnos[i]+=1;
            }
        }
        
        return turnos;
    }
    
    public static void main(String[] args) {
        boolean avanzar=false;
        double prob;
        
        Robot r=new Robot("robot1",0,(int)((Math.random()*16)+25),2012,0);
        Robot r2=new Robot("robot2",0,(int)((Math.random()*16)+25),2016,0);
        Robot r3=new Robot("robot3",0,(int)((Math.random()*16)+25),2005,0);
        Robot r4=new Robot("robot4",0,(int)((Math.random()*16)+25),2000,0);
        
        Robot array[]={r,r2,r3,r4};
        
        for(int i=0;i<array.length;i++){
            
            avanzar=false;
            
            while(!avanzar){                
                prob=Math.random();
                if(prob>=0.5){
                    array[i].setCargaA(array[i].getCargaM()*prob);
                    avanzar=true;
                }
            }
        }
        
        for(int i=0;i<array.length;i++){
            array[i].mostrar();
        }
        
        
        System.out.println("el indice del robot mas antiguo es: "+oldest(array)+" (En caso de que haya mas de un robot que coincidan en mayor antiguedad se muestra el de mayor capacidad de carga)");
        
        Robot rAntiguo=array[oldest(array)];
        rAntiguo.mostrar();
        
        int distanciaC=15;
        int carrera[]=race(array,distanciaC);
        for(int i=0;i<carrera.length;i++){
            System.out.println("El robot "+array[i].getNombre()+"("+array[i].getCargaA()+"/"+array[i].getCargaM()+") ha usado "+carrera[i]+" turnos para recorrer "+distanciaC+" distancia.");
        }
        
        System.out.println(rAntiguo.toString());
        System.out.println(rAntiguo.getClass());
        System.out.println(rAntiguo.equals(r));
        
        rAntiguo.toString();
        
    }
}
