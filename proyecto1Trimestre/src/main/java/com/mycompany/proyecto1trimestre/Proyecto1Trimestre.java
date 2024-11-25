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
        //crea una matriz con las dimensiones por defecto o las indicadas por el usuario
        
      char matriz[][]=new char[fila][columna];      
      for(int i=0;i<fila;i++){
          for(int j=0;j<columna;j++){
              matriz[i][j]=' ';
          }
      }
      return matriz;
    }
    
<<<<<<< HEAD
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
=======
    public static char[] simbolos(int fila,int columna){
        //con esta función genero un array char en el que voy a guardar de forma aleatoria los simbolos para rellenar la matriz.
        
        int cont=0,i,numsim=(fila*columna)/2;
        char conjunto[]=new char[numsim],simbolo;
        boolean repetido;
        
        while(cont<numsim){
            
            simbolo=(char)(Math.random()*(127-33)+33);          
            repetido=false;
            i=0;
            
            while(i<cont){
                if(conjunto[i]==simbolo){
                    repetido=true;
                }
                i++;
            }
            
            if(repetido==false){
                conjunto[cont]=simbolo;
                cont++;
            }
            
        }
        return conjunto;
    }
    public static char[][] rellenarMatriz(char matriz[][], char conjunto[]){
        int numsim=conjunto.length,cont=0;
        
        while(cont<numsim){
            
            for(int i=0;i<matriz.length;i++){
                for(int j=0;j<matriz[0].length;j++){
                    
                    matriz[i][j]=conjunto[cont];
                    cont++;
                    
                }
            
        }
            
        }
        
        
>>>>>>> 032a454ca91176ece21e529439d05b784d03169c
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
<<<<<<< HEAD
                    
                    matriz=rellenarMatriz(generarMatriz(fila,columna));
=======
                    matriz=(rellenarMatriz(generarMatriz(fila,columna),simbolos(fila,columna)));
>>>>>>> 032a454ca91176ece21e529439d05b784d03169c
                    System.out.println(Arrays.deepToString(matriz));
                break;
                
                case 's': salir=true;
                break;
            }
        
        
        
        }
    }
}
