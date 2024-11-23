package com.mycompany.memorion;
import java.util.*;

public class Memorion {

    public static void menu(){
        System.out.println("MEMORIÓN");
        
        System.out.println("Pulsa 'a' para entrar a los ajustes");
        
        System.out.println("Pulsa 'e' para empezar el juego");
        
        System.out.println("Pulsa 's' para salir");
    }
    
    public static char[][] generarMatriz(int fila, int columna){
    // Genera una matriz con las dimensiones por defecto o las indicadas por el usuario y la rellena con parejas de símbolos aleatorios
        char matriz[][]=new char[fila][columna];      
        
        for(int i=0;i<fila;i++){
            for(int j=0;j<columna;j++){
            matriz[i][j]=' ';
            }
        }
      
        //rellena la matriz 
        rellenarMatriz(matriz,simbolos(fila,columna));
        return matriz;
    }
    
    public static char[] simbolos(int fila,int columna){
    // Genera un array con parejas de símbolos aleatorios 
        
        int cont=0,i,numsim=(fila*columna);
        char conjunto[]=new char[numsim],simbolo;
        boolean repetido;
        
        while(cont<numsim){
            
            // Genera un símbolo aleatorio entre los caracteres imprimibles
            simbolo=(char)(Math.random()*(127-33)+33);          
            repetido=false;
            i=0;
            
            // Verifica si el símbolo ya existe en el conjunto
            while(i<cont){
                if(conjunto[i]==simbolo){
                    repetido=true;
                }
                i++;
            }
            
            // Si no está repetido, agrega el símbolo dos veces al conjunto
            if(repetido==false){
                conjunto[cont]=simbolo;
                conjunto[cont+1]=simbolo;
                cont+=2;
            }
            
        }
        
        mezclar(conjunto); //Mezcla antes del return
        return conjunto;
    }
    
    public static void mezclar(char conjunto[]){
    // Mezcla los símbolos del conjunto usando intercambios aleatorios
        
        for(int cont=0;cont<20;cont++){     //repite la mezcla 20 veces
            for(int i=0;i<conjunto.length;i++){

                int j=(int)(Math.random()*conjunto.length);

                char inter=conjunto[i]; //usa una variable de intercambio para hacer la modificación de posición de símbolos
                conjunto[i]=conjunto[j];
                conjunto[j]=inter;

            }
        }
    }
    
    public static char[][] rellenarMatriz(char matriz[][], char conjunto[]){
    // Rellena la matriz con los símbolos del conjunto ya desordenados
        int cont=0; 
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){

                matriz[i][j]=conjunto[cont];
                cont++;

            }            
        }
                                    
        return matriz;
    }
    
    public static void imprimir(char matriz[][]){
    //Imprime la matriz
    
        for(char[] fila: matriz){
            for(char celda:fila){
                
                System.out.print(celda+"\t");
            }
            System.out.println();
            
        }
    }
    
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); // Secuencia ANSI
        System.out.flush();
    }
    
    public static void main(String[] args) {
        boolean salir=false,opcond;
        char opcion;
        char matriz[][];
        int fila=3,columna=4; //Dimensiones predeterminadas
        Scanner leerC=new Scanner(System.in);
        Scanner leerN=new Scanner(System.in);
        
        while(!salir){
            menu();
            opcion=leerC.next().charAt(0);
            
            if(opcion!='a' && opcion!='e' && opcion!='s'){
                System.out.println("Opción no válida.");
            }
            
            switch(opcion){
                
                case 'a':
                    
                    opcond=false;
                    System.out.println("Primero debes elegir las dimensiones del tablero.");
                    System.out.println("Recuerda que necesitamos una cantidad de celdas par.");
                    
                    while(!opcond){
                        
                        System.out.println("Introduce el número de filas: ");
                        fila=leerN.nextInt();
                        System.out.println("Introduce el número de columnas");
                        columna=leerN.nextInt();
                        if((fila*columna)%2!=0 || fila<=0 || columna<=0){
                            System.out.println("¡Las dimensiones introducidas no son válidas!");
                        }
                        else{
                            opcond=true;
                        }
                    }
                    
                break;
                
                case 'e':
                    
                    matriz=generarMatriz(fila,columna);
                    System.out.println(Arrays.deepToString(matriz));
                    imprimir(matriz);
                    
                break;
                
                case 's': salir=true;
                break;
            }
        
        
        
        }
    }
}
