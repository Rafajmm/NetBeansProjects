package com.mycompany.memorion2;

import java.util.*;

public class Memorion2 {

    
    public static void menu() {
        System.out.println("MEMORIÓN");
        System.out.println("Pulsa 'a' para entrar a los ajustes");
        System.out.println("Pulsa 'e' para empezar el juego");
        System.out.println("Pulsa 's' para salir");
    }

    // Genera una matriz con las dimensiones por defecto o las indicadas por el usuario y la rellena con parejas de símbolos aleatorios
    public static char[][] generarMatriz(int fila, int columna) {
        char matriz[][] = new char[fila][columna]; 
        
        
        for(int i=0;i<fila;i++){
          for(int j=0;j<columna;j++){
              matriz[i][j]=' ';
          }
        }
        
        // Rellena la matriz con símbolos generados
        rellenarMatriz(matriz, simbolos(fila, columna));
        return matriz;
    }

    // Genera un array con parejas de símbolos aleatorios para rellenar la matriz
    public static char[] simbolos(int fila, int columna) {
        int cont = 0;
        int numsim = fila * columna; 
        char conjunto[] = new char[numsim];
        boolean repetido;

        while (cont < numsim) {
            // Genera un símbolo aleatorio entre los caracteres imprimibles
            char simbolo = (char) (Math.random() * (127 - 33) + 33);
            repetido = false;
            
            // Verifica si el símbolo ya existe en el conjunto
            for (int i = 0; i < cont; i++) {
                if (conjunto[i] == simbolo) {
                    repetido = true;
                    break;
                }
            }
            
            // Si no está repetido, agrega el símbolo dos veces al conjunto
            if (!repetido) {
                conjunto[cont] = simbolo;
                conjunto[cont + 1] = simbolo;
                cont += 2;
            }
        }

        mezclar(conjunto); // Mezcla los símbolos en el conjunto
        return conjunto;
    }

    // Mezcla los elementos de un array usando intercambios aleatorios
    public static void mezclar(char conjunto[]) {
        for (int cont = 0; cont < 20; cont++) { // Realiza 20 pasadas de mezcla
            for (int i = 0; i < conjunto.length; i++) {
                int j = (int) (Math.random() * conjunto.length); // Índice aleatorio
                char inter = conjunto[i];
                conjunto[i] = conjunto[j];
                conjunto[j] = inter;
            }
        }
    }

    // Rellena la matriz con los símbolos del conjunto ya desordenados
    public static char[][] rellenarMatriz(char matriz[][], char conjunto[]) {
        int cont = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = conjunto[cont];
                cont++;
            }
        }

        return matriz;
    }

    public static void imprimir(char matriz[][]) {
    // Imprime la matriz dentro de una tabla con bordes

        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Línea superior de la tabla
        System.out.print("┌");
        for (int i = 0; i < columnas; i++) {
            System.out.print("───");
            if (i < columnas - 1) {
                System.out.print("┬");
            }
        }
        System.out.println("┐");

        // Filas de la tabla
        for (int i = 0; i < filas; i++) {
            System.out.print("│");
            for (int j = 0; j < columnas; j++) {
                System.out.print(" " + matriz[i][j] + " ");
                System.out.print("│");
            }
            System.out.println();

            // Línea intermedia o inferior
            if (i < filas - 1) {
                System.out.print("├");
                for (int j = 0; j < columnas; j++) {
                    System.out.print("───");
                    if (j < columnas - 1) {
                        System.out.print("┼");
                    }
                }
                System.out.println("┤");
            }
        }

        // Línea inferior de la tabla
        System.out.print("└");
        for (int i = 0; i < columnas; i++) {
            System.out.print("───");
            if (i < columnas - 1) {
                System.out.print("┴");
            }
        }
        System.out.println("┘");
    }

    // Limpia la pantalla en terminales compatibles con ANSI
    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J"); // Secuencia ANSI para limpiar
        System.out.flush();
    }

    public static void main(String[] args) {
        boolean salir = false; // Controla el bucle principal
        char opcion; // Almacena la opción seleccionada por el usuario
        char matriz[][];
        int fila = 3, columna = 4,zoom=1; // Valores predeterminadas del tablero
        Scanner leerC = new Scanner(System.in); // Para leer caracteres
        Scanner leerN = new Scanner(System.in); // Para leer números

        while (!salir) {
            menu(); // Muestra el menú principal
            opcion = leerC.next().charAt(0); // Lee la opción del usuario

            // Mensaje de validación si la opción no es válida
            if (opcion != 'a' && opcion != 'e' && opcion != 's') {
                System.out.println("Opción no válida.");
            }

            switch (opcion) {
                case 'a':
                    // Ajustes: Permite al usuario cambiar las dimensiones del tablero
                    boolean opcond = false;
                    System.out.println("Primero debes elegir las dimensiones del tablero.");
                    System.out.println("Recuerda que necesitamos una cantidad de celdas par.");
                    
                    while (!opcond) {
                        System.out.println("Introduce el número de filas: ");
                        fila = leerN.nextInt();
                        System.out.println("Introduce el número de columnas: ");
                        columna = leerN.nextInt();
                        
                        // Valida las dimensiones introducidas
                        if ((fila * columna) % 2 != 0 || fila <= 0 || columna <= 0) {
                            System.out.println("¡Las dimensiones introducidas no son válidas!");
                        } else {
                            opcond = true;
                        }
                    }
                    
                    opcond=false;
                    System.out.println("Ahora introduce el zoom");
                    
                    while(!opcond){
                        System.out.println("Elige entre 1, 2 o 4");
                        zoom=leerN.nextInt();
                        if(zoom==1 || zoom==2 || zoom==4){
                            opcond=true;
                        }
                    }
                    
                    
                    break;

                case 'e':
                    // Comienza el juego: genera e imprime el tablero
                    matriz = generarMatriz(fila, columna);
                    imprimir(matriz);
                    break;

                case 's':
                    // Finaliza el programa
                    salir = true;
                    break;
            }
        }
    }
}
