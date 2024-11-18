package com.mycompany.actividad511;
import java.util.*;

public class Actividad511 {
    public static int[] buscarTodos(int vector[], int clave){
        int resul[]=new int[0], pos=0,longi=0;
        Arrays.sort(vector);
        
        for(int i=0;i<vector.length;i++){
                        
            if(vector[i]==clave){
                longi++;
                System.out.println(longi);
                resul=Arrays.copyOf(resul, longi);
                System.out.println(Arrays.toString(resul));
                resul[i]=i;
                System.out.println(Arrays.toString(resul));
                vector[i]=-1;
                Arrays.sort(vector);
            }
            
        }
        
        return resul;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int vector[]={3,10,5,6,7,8};
        System.out.println(Arrays.toString(buscarTodos(vector,7)));
    }
}
