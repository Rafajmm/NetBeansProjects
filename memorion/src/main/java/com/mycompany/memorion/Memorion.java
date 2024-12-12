package com.mycompany.memorion;
import java.util.*;

public class Memorion {

    public static void menu(){
        System.out.println("MEMORIÓN");
       
        System.out.println("Pulsa 'a' para entrar a los ajustes");
       
        System.out.println("Pulsa 'e' para empezar el juego");
       
        System.out.println("Pulsa 's' para salir");
    }
   
    public static char[][] generarMatriz(int ajustes[]){
    // Genera una matriz con las dimensiones por defecto o las indicadas por el usuario y la rellena con parejas de símbolos aleatorios
        char matriz[][]=new char[ajustes[0]][ajustes[1]];      
       
        for(int i=0;i<ajustes[0];i++){
            for(int j=0;j<ajustes[1];j++){
            matriz[i][j]=' ';
            }
        }
     
       
        return matriz;
    }
   
    public static char[] simbolos(int ajustes[]){
    // Genera un array con parejas de símbolos aleatorios
       
        int cont=0,i,numsim=(ajustes[0]*ajustes[1]);
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
   
    public static void comprobarContenido(char matriz[][]){
   
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                System.out.print(matriz[i][j]+"\t");              
            }                
            System.out.println();
        }            
    }
   
    public static int[] stringToInt(String casillas[]){
        // transforma los string introducidos por teclado en enteros y lo guarda en un array
        String casilla1[]=casillas[0].split("-");
        String casilla2[]=casillas[1].split("-");
        int coordenadas[]=new int[4];
        
        // Convertir los string a enteros usando el metodo .parseInt()
        coordenadas[0]=(Integer.parseInt(casilla1[0]))-1;  //restamos 1 para que esté dentro de rango
        coordenadas[1]=(Integer.parseInt(casilla1[1]))-1;  
        coordenadas[2]=(Integer.parseInt(casilla2[0]))-1;  
        coordenadas[3]=(Integer.parseInt(casilla2[1]))-1;  
       
        return coordenadas;
    }

   
    public static boolean condiciones(char mjuego[][],int coordenadas[]){
        int posminima=0, fila=coordenadas[0],fila2=coordenadas[2],columna=coordenadas[1],columna2=coordenadas[3];
        boolean condicion=true;
       
        if(fila<posminima || fila2<posminima ||columna<posminima || columna2<posminima || fila>=mjuego.length || fila2>=mjuego.length || columna>=mjuego[0].length || columna2>=mjuego[0].length){
            System.out.println("Has seleccionado alguna posición fuera de rango");
            condicion=false;
        }
       
        else if(fila==fila2 && columna==columna2){
            System.out.println("Has seleccionado dos veces la misma casilla");
            condicion=false;
        }
         
        else if(mjuego[fila][columna]!=' ' || mjuego[fila2][columna2]!=' '){
            System.out.println("No puedes seleccionar una casilla que ya has descubierto.");
            condicion=false;
        }
       
        return condicion;
    }
   
   
   
    public static void jugar(char matriz[][],char mjuego[][],int coordenadas[],int ajustes[]){
        //esta función comprueba que las casillas elegidas cumplen las condiciones antes de modificar la matriz mjuego
        //luego copia en mjuego el contenido de las casillas elegidas por el usuario, si el contenido es distinto vuelve a dejar
        //mjuego como estaba antes.
       
        int fila=coordenadas[0],fila2=coordenadas[2],columna=coordenadas[1],columna2=coordenadas[3];

        
        if(condiciones(mjuego,coordenadas)){
            mjuego[fila][columna]=matriz[fila][columna];
            mjuego[fila2][columna2]=matriz[fila2][columna2];
            imprimirJugar(mjuego,ajustes[5]);
           
            try {
            //pausa de x segundos antes de limpiar la pantalla
                Thread.sleep(ajustes[2]);  
            }
            catch (InterruptedException e) {
                e.printStackTrace();  
            }
           
           
            limpiarPantalla(); //limpia pantalla pero sólo funciona en cmd de windows y la terminal de linux
           
           
            if(matriz[fila][columna]!=matriz[fila2][columna2]){
                mjuego[fila][columna]=' ';
                mjuego[fila2][columna2]=' ';
                ajustes[4]--;
            }
           
            else{
                ajustes[3]++;
            }
        }
           
        
    }
    
    public static boolean comprobarDigitos(String casillas[]){
        boolean cond = true; 

        // Necesitamos un bucle anidado para dividir las dos casillas en sus filas y columnas correspondientes
        for (int i=0;i<casillas.length;i++) {
            
            String casilla[]=casillas[i].split("-");
            if(casilla.length<2){  //Si el array creado a partir del string dentro de casillas tiene un tamaño menor que dos para la ejecucion
                cond=false;
                break;
            }
            
            for (int z=0;z<casilla.length;z++) {
                
                if (casilla[z]==null || casilla[z].isEmpty()) { // Si alguna fila o columna está vacía
                    cond = false;
                    break;
                    
                } 
                                
                try {
                    Integer.parseInt(casilla[z]); // Intentamos convertir el string a un entero
                } 
                catch (NumberFormatException e) {
                    cond = false; // Si falla, no es un número
                    break;
                }
                
            }
            if (!cond) break; // Salimos si ya se encontró un valor no numérico
        }

        return cond;
    }
   
    public static long ejecutarSolo(char matriz[][],int ajustes[]){
        Scanner leerN=new Scanner(System.in);
        boolean terminar=false;
        long tiempoFinal=0;
        String coordenadas[]=new String[2];
        int casillas[]=new int[4];
        int pareja=(ajustes[0]*ajustes[1])/2;
        char mjuego[][]=generarMatriz(ajustes);
                   
        while(!terminar){

            imprimirJugar(mjuego,ajustes[5]);
            boolean terminar2=false;
            
            while(!terminar2){
                System.out.println();
                System.out.println("introduce la primera casilla con el formato x-y");
                coordenadas[0]=leerN.next();
                System.out.println("introduce la segunda casilla con el formato x-y");
                coordenadas[1]=leerN.next();
                
                if(!comprobarDigitos(coordenadas)){
                    System.out.println("Has introducido alguna letra o símbolo");
                }
                
                else if(coordenadas[0].length()<3 || coordenadas[0].length()>5 || coordenadas[1].length()<3 || coordenadas[1].length()>5){
                    System.out.println("Has introducido un formato no válido.");
                }
                
                else if((coordenadas[0].indexOf('-')!=1 && coordenadas[0].indexOf('-')!=2) || (coordenadas[1].indexOf('-')!=1 && coordenadas[1].indexOf('-')!=2)){
                    System.out.println("Has introducido un formato no válido.");
                }
                
                else if((coordenadas[0].length()==3 && coordenadas[0].indexOf('-')!=1) || (coordenadas[1].length()==3 && coordenadas[1].indexOf('-')!=1)){
                    
                }
                                                 
                else{
                    terminar2=true;
                }
            }   
            
            casillas=stringToInt(coordenadas);
            jugar(matriz,mjuego,casillas,ajustes);
            
            if(ajustes[3]==pareja-1){
                tiempoFinal=System.currentTimeMillis();
                System.out.println("¡Has ganado!");
                comprobarContenido(matriz);
                
                terminar=true;
            }
            
            else if(ajustes[4]==0){
                System.out.println("¡Has perdido!");
                
                terminar=true;
            }
            else{
                System.out.println("Llevas "+ajustes[3]+" parejas encontradas.");
                System.out.println("Te quedan "+ajustes[4]+" intentos");
            }
        }
        
        return tiempoFinal;
    }
   
    public static void imprimirJugar(char mjuego[][], int zoom){
    //Imprime la matriz cada turno
       
        for(int i=0;i<mjuego[0].length;i++){
            System.out.print("     "+(i+1)+"    ");
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

            ProcessBuilder processBuilder;
            if (os.contains("Windows")) {
                // En Windows, ejecutamos el comando 'cls'
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // En sistemas Unix (Linux, macOS), ejecutamos 'clear'
                processBuilder = new ProcessBuilder("clear");
            }

            // Inicia el proceso
            processBuilder.inheritIO().start().waitFor();

        }
       
        catch (final Exception e) {
            e.printStackTrace();
        }
    }
   
    public static String tiempoLegible(long tiempoMili) {
        long segundosTotales = tiempoMili / 1000;
       
        long horas = segundosTotales / 3600;
       
        long minutos = (segundosTotales % 3600) / 60;
       
        long segundos = segundosTotales % 60;
       
        return "Tiempo total: "+horas+" horas "+minutos+" minutos "+segundos+" segundos";       
    }
   
    public static void main(String[] args) {
        boolean salir=false,opajus;
        char opcion;
        char matriz[][];
        long tablaPuntos[]=new long[0],puntos;
        int ajustes[]={3,4,3000,0,9,1};
        int fallos=0,parejas=0;
        int fila,columna,segundos; //Dimensiones predeterminadas
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
                   
                    opajus=false;
                    System.out.println("Primero debes elegir las dimensiones del tablero.");
                    System.out.println("Recuerda que necesitamos una cantidad de celdas par.");
                   
                    while(!opajus){
                       
                        System.out.println("Introduce el número de filas: ");
                        fila=leerN.nextInt();
                        System.out.println("Introduce el número de columnas");
                        columna=leerN.nextInt();
                        if((fila*columna)%2!=0 || (fila*columna)>120 || fila<=0 || columna<=0){
                            System.out.println("¡Las dimensiones introducidas no son válidas!");
                        }
                        else{
                            ajustes[0]=fila;
                            ajustes[1]=columna;
                            opajus=true;
                        }
                    }
                                       
                    while(opajus){
                        System.out.println("Ahora introduce el tiempo de visualizacion en segundos (entre 1 y 5)");
                        segundos=leerN.nextInt();
                        if(segundos>0 && segundos<6){
                            ajustes[2]=(segundos*1000);
                            opajus=false;
                        }
                        else{
                            System.out.println("Has introducido un numero fuera de rango");
                        }
                    }
                   
                    while(!opajus){
                       
                        parejas=(ajustes[0]*ajustes[1])/2;
                        fallos=parejas+(parejas/2);
                       
                        System.out.println("Introduce el numero de fallos (el máximo dependerá del tamaño de la tabla");
                        System.out.println("y no puede superar el numero de parejas mas su mitad, en este caso: "+fallos+")");
                        ajustes[4]=leerN.nextInt();
                        ajustes[3]=0;
                       
                        if(ajustes[4]<=0 || ajustes[4]>fallos){
                            System.out.println("Fallos fuera de rango");
                        }
                        else{
                            opajus=true;
                        }                    
                    }
                    
                    while(opajus){
                        System.out.println("Por ultimo elige el zoom: 1, 2 ó 3");
                        ajustes[5]=leerN.nextInt();
                        if(ajustes[5]!=1 && ajustes[5]!=2 && ajustes[5]!=3){
                            System.out.println("No has introducida una opción válida");
                        }
                        else{ 
                            opajus=false; 
                        }   
                    }
                   
                   
                break;
               
                case 'e':
                    char simbolos[]=simbolos(ajustes);
                    long tiempoInicial=0,tiempoFinal=0;
                    
                    puntos=0;
                    matriz=rellenarMatriz(generarMatriz(ajustes),simbolos);
                    //comprobarContenido(matriz); 
                                       
                    System.out.println("Comienza el juego. Tienes "+ajustes[4]+" intentos.");
                   
                    tiempoInicial=System.currentTimeMillis();
                    
                    tiempoFinal=ejecutarSolo(matriz,ajustes);
                    
                    if(tiempoFinal>0){
                        ajustes[3]=0;
                        parejas=(ajustes[0]*ajustes[1])/2;
                        fallos=parejas+(parejas/2);
                        ajustes[4]=fallos;
                        puntos=tiempoFinal-tiempoInicial;
                        System.out.println(tiempoLegible(puntos));
                        tablaPuntos=Arrays.copyOf(tablaPuntos, tablaPuntos.length+1); //copiar tabla de puntos aumentando tamaño 
                        tablaPuntos[tablaPuntos.length-1]=puntos;                     //guardar puntuación en el último espacio
                        Arrays.sort(tablaPuntos); 
                    }
                    
                    else{
                        ajustes[3]=0;
                        parejas=(ajustes[0]*ajustes[1])/2;
                        fallos=parejas+(parejas/2);
                        ajustes[4]=fallos;
                    }
                   
                    System.out.println("Las mejores puntuaciones son"+Arrays.toString(tablaPuntos));                                                                                            
                   
                break;
               
                case 's': salir=true;
                break;
            }
       
       
       
        }
    }
}
