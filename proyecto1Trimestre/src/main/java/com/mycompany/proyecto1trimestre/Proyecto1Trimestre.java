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
        //crea una matriz con las dimensiones indicadas en teclado
        
      char matriz[][]=new char[fila][columna];      
      for(int i=0;i<fila;i++){
          for(int j=0;j<columna;j++){
              matriz[i][j]=' ';
          }
      }
      return matriz;
    }
    
    public static char[][] rellenarMatriz(char matriz[][]){
        boolean repetido=false;
        int cont=0,pos1=matriz.length-1,pos2=matriz[0].length-1;
        char simbolo;
        while(cont<(matriz.length*matriz[0].length)){
            simbolo=(char)(Math.random()*(48-33)+33);
            System.out.println(simbolo);
            repetido=true;
            for(int i=0;i<matriz.length;i++){
                for(int j=0;j<matriz[0].length;j++){                    
                    repetido=false;
                    if(simbolo==matriz[i][j]){
                        
                    }
                    if(repetido==false){
                        matriz[i][j]=simbolo;
                        
                    }
                }               
            }            
            cont++;
        }        
        return matriz;
    }
    
    public static void main(String[] args) {
        boolean salir=false;
        char opcion;
        char matriz[][];
        int fila=3,columna=4;
        Scanner leerC=new Scanner(System.in);
        Scanner leerN=new Scanner(System.in);
        
        while(salir==false){
            menu();
            opcion=leerC.next().charAt(0);
            switch(opcion){
                
                case 'a':
                    while((fila*columna)%2!=0){
                        System.out.println("Primero debes elegir las dimensiones del tablero. Recuerda que necesitamos una cantidad de celdas par.");
                        System.out.println("Introduce el número de filas: ");
                        fila=leerN.nextInt();
                        System.out.println("Introduce el número de columnas");
                        columna=leerN.nextInt();
                        if(fila*columna!=0){
                            System.out.println("Las dimensiones introducidas no son válidas.");
                        }
                    }
                    
                break;
                
                case 'e': 
                    
                    matriz=rellenarMatriz(generarMatriz(fila,columna));
                    System.out.println(Arrays.deepToString(matriz));
                break;
                
                case 's': salir=true;
                break;
            }
        
        
        
        }
    }
}
