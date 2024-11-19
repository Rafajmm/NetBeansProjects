package com.mycompany.proyecto1trimestre;
import java.util.*;

public class Proyecto1Trimestre {
    
    public static void menu(){
        System.out.println("MEMORIÓN");
        
        System.out.println("Pulsa 'a' para entrar a los ajustes");
        
        System.out.println("Pulsa 'e' para empezar el juego");
        
        System.out.println("Pulsa 's' para salir");
    }
    
    public static char[][] generarMatriz(int fila, int columna){
      char matriz[][]=new char[fila][columna];
      char simbolos[]=new char[0];
      int pos=0;
      for(int i=33;i<127;i++){
          simbolos=Arrays.copyOf(simbolos,simbolos.length+1);
          simbolos[pos]=(char)i;
          System.out.println(simbolos);
      }
      for(int i=0;i<fila;i++){
          for(int j=0;j<columna;j++){
              matriz[i][j]=(char)(Math.random()*(127-33)+33);
          }
      }
      return matriz;
    }
    
    public static void main(String[] args) {
        boolean salir=false;
        char opcion;
        String matriz;
        Scanner leerC=new Scanner(System.in);
        Scanner leerN=new Scanner(System.in);
        
        while(salir==false){
            menu();
            opcion=leerC.next().charAt(0);
            switch(opcion){
                
                case 'a': 
                    
                break;
                
                case 'e': 
                    matriz=Arrays.toString(generarMatriz(3,4));
                    System.out.println(matriz);
                break;
                
                case 's': salir=true;
                break;
            }
        
        
        
        }
    }
}
