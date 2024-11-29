package ejercicio2;
import java.util.*;

public class Ejercicio2 {

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
   
    public static void opcionA(){
        int alea,rango=15-8;
       
        for(int i=1;i<=10;i++){
            alea=(int)(Math.random()*rango)+8;
           
            System.out.println(i+"-> "+alea);
        }
    }
   
    public static void opcionB(){
        int rango=10-5,alea;
        alea=(int)(Math.random()*rango)+5;
       
        for(int i=1;i<=alea;i++){
           
            System.out.println(i+"-> "+Math.random());
        }
    }
   
    public static void opcionC(){
        int rango=10-5,veces,cont=0,alea;
        veces=(int)(Math.random()*rango)+5;
   
        for(int i=0;i<veces;i++){
            alea=(int)(Math.random()*100);
       
            if(alea>50){
                System.out.println("-> "+alea);
            }
            else cont++;
        }
        System.out.println("No se han mostrado "+cont+" números por estar debajo de 50");
    }
    
    public static void opcionD(){
        int alea,alea1,cont=0;
        
        for(int i=0; i<100;i++){
            alea=(int)(Math.random()*101);
            alea1=(int)(Math.random()*101);
            
            if(alea<alea1 && alea1<50){
                System.out.println(alea+" "+alea1);
            }
            else cont++;
        }
        System.out.println("No se han mostrado "+cont+" parejas por no cumplir una o varias condiciones");
    }
    
    public static void opcionE(){
        double a=Math.random();
        
        if(a>0.4 && a<0.6){
            opcionA();
            opcionB();
            opcionC();
            opcionD();
        }
        else if(a<0.25 || a>0.75){
            opcionA();
            opcionB();
        }
        else{
            opcionC();
            opcionD();
        }
    }
    
    public static void opcionF(int rango1, int rango2){
        int rango=(rango2+1)-rango1,alea,media,cont=0;
        boolean cond=true;
        
        media=rango1+(int)((rango2-rango1)/2);
        
        while(cond==true){
            alea=(int)(Math.random()*rango)+rango1;
            System.out.println(alea);
            cont++;
            if(alea==media){
                System.out.println("Se han necesitado "+cont+" intentos");
                cond=false;
                
            }
        }
    }
    

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int a,b;
        
//        menu();
//        opcionA();
//        opcionB();
//        opcionC();
//        opcionD();
//        opcionE();
//        opcionF(6,17);

        while(true) {
            menu();
            System.out.println("Elige una opcion: ");
            char opcion=leer.nextLine().toLowerCase().charAt(0);

            switch (opcion) {
                case 'a':
                    opcionA();
                    break;
                case 'b':
                    opcionB();
                    break;
                case 'c':
                    opcionC();
                    break;
                case 'd':
                    opcionD();
                    break;
                case 'e':
                    opcionE();
                    break;
                case 'f':
                    System.out.println("Introduce el primer parametro: ");
                    a=leer.nextInt();
                    System.out.println("Introduce el segundo parametro: ");
                    b=leer.nextInt();
                    opcionF(a,b);
                    break;
                case 'g':
                    System.out.println("Saliendo...");
                    return;
        
            }
   
        }
    }
}