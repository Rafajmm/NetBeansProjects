package e2modificado;

import java.util.Scanner;


public class E2Modificado {
    public static double aleaRango(int rangoI, int rangoS) {
        return (Math.random() * (rangoS - rangoI) + rangoI);
    }

    public static int apartadoABC(int cantidad, int rangoI, int rangoS, int minimo) //A. Mostrar 10 números aleatorios en el rango [8-14]
    //B. Mostrar X número aleatorios (siendo los posibles valores de X el rango [5-9])
    //C. Igual que el apartado B, pero con X en el rango [0-100] y mostrando los valores únicamente si son mayores que 50. En este caso se indicará cuántos números se han generado y NO se han mostrado por no cumplir la condición.
    {
        int descartados = 0;
        int alea;

        for (int i = 0; i < cantidad; i++) {
            alea = (int) aleaRango(rangoS, rangoI);
            if (alea > minimo) {
                System.out.println(alea);
            } else {
                descartados++;
            }
        }

        return descartados;
    }

    //D. Mostrar parejas de números aleatorios en el rango [0-100] si ambos son menores que 50 y si el primero generado es menor que el segundo. De nuevo, indicar cuántas parejas se desechan por no cumplir los criterios.
    public static int apartadoD(int cantidad){
    //D. Mostrar parejas de números aleatorios en el rango [0-100]
    //si ambos son menores que 50 y si el primero generado es menor
    //que el segundo. De nuevo, indicar cuántas parejas se desechan por no cumplir los criterios.
    
    int descartados=0;
    int alea1, alea2;

    for(int i=0; i<cantidad ; i++)
    {
            alea1 = (int) aleaRango(0, 100);
            alea2 = (int) aleaRango(0, 100);
            //se muestra la pareja si AMBOS son <50 y alea1<alea2
            if(alea1<50 && alea2<50 && alea1<alea2)
            {
                System.out.println(alea1 + " y " + alea2);
            }
            else
            {
                descartados++;
            }
    }

    return descartados;
    }
    
    
    public static void apartadoE() //E. Generar un número aleatorio en el rango [0, 1). Dependiendo de su valor, se hace lo siguiente:
    //- Entre 0.4 y 0.6: hacer A, B, C y D
    //- Menor que 0.25 o mayor que 0.75: hacer A y B.
    //- En cualquier otro caso, hacer C y D.
    {
        double alea = aleaRango(0, 1); //Math.random()
        int cuantos;

        if (alea < 0.25 || alea > 0.75) {
            //apartadoA
            apartadoABC(10, 8, 14, 0);

            //apartadoB
            cuantos = (int) aleaRango(5, 9); //X números
            apartadoABC(cuantos, 30, 40, 0);
        } else {

            if (alea >= 0.4 && alea <= 0.6) {
                //apartadoA
                apartadoABC(10, 8, 14, 0);

                //apartadoB
                cuantos = (int) aleaRango(5, 9); //X números
                apartadoABC(cuantos, 30, 40, 0);

                //apartadoC
                cuantos = (int) aleaRango(0, 100);

                int descartados = apartadoABC(cuantos, 0, 100, 50);
                System.out.println("Descartados: " + descartados);

                //apartadoD
                apartadoD((int)aleaRango(0,100));
            } else {
                //apartadoC
                cuantos = (int) aleaRango(0, 100);

                int descartados = apartadoABC(cuantos, 0, 100, 50);
                System.out.println("Descartados: " + descartados);

                //apartadoD
                apartadoD((int)aleaRango(0,100));
            }

        }
    }

    public static int apartadoF(int rangoInferior, int rangoSuperior) //F. Generar números aleatorios en un rango dado por el usuario e indicar cuántos hay que generar hasta obtener el número el que está en la mitad de ese rango. Por ejemplo, si el usuario indica 6 y 17, habrá que comprobar cuántos números se generan hasta obtener el 5 ( equivalente a (17-6 )/ 2)
    {
        int iteraciones = 0;
        int alea;
        int mitadRango = ((rangoSuperior - rangoInferior) / 2) + rangoInferior;
        mitadRango = (rangoInferior + rangoSuperior) / 2; //otra forma de calcular el valor a buscar

        do {
            alea = (int) aleaRango(rangoInferior, rangoSuperior);

            iteraciones++;

        } while (alea != mitadRango);

        return iteraciones;
    }
    
    public static void menu(){
        System.out.println("--MENU--");
        System.out.println("A. 10 Aleatorios [8-14].");
        System.out.println("B. Mostrar entre 5 y 9 aleatorios.");
        System.out.println("C. Mostrar entre 0 y 100 aleatorios mayores que 50.");
        System.out.println("D. Parejas de aleatorios con condición.");
        System.out.println("E. Aleatorio para opciones anteriores.");
        System.out.println("F. Iteraciones hasta encontrar la media.");
        System.out.println("G. Salir.");
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in), leer2=new Scanner(System.in);
        
        int a,b;
        boolean condwhile=true;
//        menu();
//        opcionA();
//        opcionB();
//        opcionC();
//        opcionD();
//        opcionE();
//        opcionF(6,17);

        while(condwhile) {
            menu();
            System.out.println("Elige una opcion: ");
            char opcion=leer.nextLine().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    apartadoABC(10, 8, 14, 0);
                    break;
                case 'b':
                    apartadoABC((int)aleaRango(5,9), 8, 14, 0);
                    break;
                case 'c':
                    apartadoABC((int)aleaRango(0,100),0,100,-1);
                    System.out.println("Se han descartado "+apartadoABC((int)aleaRango(0,100),0,100,50)+" numeros");
                    break;
                case 'd':
                    apartadoD((int)aleaRango(0,100));
                    System.out.println("Se han descartado "+apartadoD((int)aleaRango(0,100))+" parejas");
                    break;
                case 'e':
                    apartadoE();
                    break;
                case 'f':
                    System.out.println("Introduce el primer parametro: ");
                    a=leer2.nextInt();
                    System.out.println("Introduce el segundo parametro: ");
                    b=leer2.nextInt();
                    
                    System.out.println(apartadoF(a,b));
                    break;
                case 'g':
                    System.out.println("Saliendo...");
                    condwhile=false;
                    break;        
            }   
        }
        
    }    
}
