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
    
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                System.out.print(matriz[i][j]+"\t");            
                        
                
            }
                
            System.out.println();
        }
            
    }
    
    public static int[] jugar(char matriz[][],char mjuego[][],int fila,int columna,int fila2,int columna2,int[] contJ){
        int posminima=0;
        
        if(fila<posminima || fila2<posminima || columna<posminima || columna2<posminima || fila>=matriz.length || fila2>=matriz.length || columna>=matriz[0].length || columna2>=matriz[0].length){
            System.out.println("Has seleccionado alguna posición fuera de rango");
        }
        
        else if(fila==fila2 && columna==columna2){
            System.out.println("Has seleccionado dos veces la misma casilla");
        }
         
        else if(mjuego[fila][columna]!=' ' || mjuego[fila2][columna2]!=' '){
            System.out.println("No puedes seleccionar una casilla que ya has descubierto.");
        }

        else{
            mjuego[fila][columna]=matriz[fila][columna];
            mjuego[fila2][columna2]=matriz[fila2][columna2];
            imprimirJugar(mjuego);
            
            if(matriz[fila][columna]!=matriz[fila2][columna2]){
                mjuego[fila][columna]=' ';
                mjuego[fila2][columna2]=' ';
                contJ[1]--;
            }
            
            else{
                contJ[0]++;
            }
        }
            
        return contJ;
    }
    
    public static void imprimirJugar(char mjuego[][]){
    //Imprime la matriz
        
        for(int i=0;i<mjuego[0].length;i++){
            System.out.print("     "+(i+1)+"   ");
        }
        System.out.println();
        
        for (int i=0;i<mjuego[0].length;i++){
            System.out.print("  --------");
        }
        System.out.println();
        
        
        for(int i=0;i<mjuego.length;i++){
            System.out.print((i+1)+"|");
            for(int j=0;j<mjuego[0].length;j++){       
                
                System.out.print("    "+mjuego[i][j]+"    |");
                
            }    
            
            System.out.println();
            for (int k=0;k<mjuego[0].length;k++){
                System.out.print("  --------");
            }
            System.out.println();
        }
        
        
        
        
        
        
    }
    
    public static void limpiarPantalla() {
        try {  
              final String os = System.getProperty("os.name");
              System.out.println(os);
              if (os.contains("Windows")) {  
                Runtime.getRuntime().exec("cls");  
            }
            else {  
                Runtime.getRuntime().exec("clear");  
            } 
        }  
        catch (final Exception e) {  
            e.printStackTrace();  
        }
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
                    char mjuego[][]=generarMatriz(fila,columna);
                    char simbolos[]=simbolos(fila,columna);
                    boolean terminar=false;
                    int pareja=(fila*columna)/2;
                    int efila1,ecolumna1,efila2,ecolumna2,contJ[]={0,(pareja+(pareja/2))};
                    matriz=rellenarMatriz(generarMatriz(fila,columna),simbolos);
                    imprimir(matriz);
                    
                    System.out.println("Comienza el juego. Tienes "+contJ[1]+" intentos.");
                    
                    while(!terminar){
                        
                        imprimirJugar(mjuego);
                        System.out.println("introduce la fila de tu primera elección");
                        efila1=leerN.nextInt()-1;
                        System.out.println("introduce la fila de tu primera elección");
                        ecolumna1=leerN.nextInt()-1;
                        System.out.println("introduce la fila de tu primera elección");
                        efila2=leerN.nextInt()-1;
                        System.out.println("introduce la fila de tu primera elección");
                        ecolumna2=leerN.nextInt()-1;
                        
                        contJ=jugar(matriz,mjuego,efila1,ecolumna1,efila2,ecolumna2,contJ);
                        System.out.println("Llevas "+contJ[0]+" parejas encontradas.");
                        System.out.println("Te quedan "+contJ[1]+" intentos");
                        
                        if(contJ[0]==pareja){
                            System.out.println("¡Has ganado!");
                            terminar=true;
                        }
                        if(contJ[1]==0){
                            System.out.println("¡Has perdido!");
                            terminar=true;
                        }
                    }
                    
                    
                break;
                
                case 's': salir=true;
                break;
            }
        
        
        
        }
    }
}
