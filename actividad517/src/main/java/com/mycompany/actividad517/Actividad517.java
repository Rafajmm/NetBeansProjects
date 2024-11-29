package com.mycompany.actividad517;
import java.util.*;

public class Actividad517 {
    
    public static int[] suma(int t[],int nE){
        int suma[]=new int[t.length-nE+1];
        for(int i=0;i<suma.length;i++){
            for(int j=0;j<nE;j++){
                suma[i]+=t[j+i];
            }
        }
        
        return suma;
    }

    public static void main(String[] args){
        int t[]={10,1,5,8,9,2},numElementos=3;
        System.out.println(Arrays.toString(suma(t,numElementos)));
        
    }  
}