package hola;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class Hola {

    public static void mostrarDigitos(int v){  //esta funcion no devuelve nada
        for(int i=0;i<v;i++){
            System.out.print(i%10);
        }
    }
    public static int fCuadrado(int x){ //esta funcion devuelve un int
        return x*x;
    }
    public static void menuMostrar(){
        System.out.println("");
        System.out.println("Menú principal");
        System.out.println("Primera opcion");
        System.out.println("Segunda opcion");
        System.out.println("Tercera opcion");
    }
    public static boolean aMayorb(int a, int b){
        boolean resul;
        if(a>b){
            resul=true;
        }        
        else{
            resul=false;
        }
        return resul;
    }

    public static void main(String[] args){
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce un número entero");
        int n=leer.nextInt();
        
        while(n!=0){
            int nAlea=(int)(Math.random()*n)+1;
            System.out.print(n+" "+nAlea+" ");
            mostrarDigitos(n);
            System.out.print("#");
            mostrarDigitos(nAlea);
            System.out.println("");
            System.out.println("Introduce un número entero");
            n=leer.nextInt();
        }
        
        menuMostrar();
        System.out.println(fCuadrado(3));
        System.out.println(aMayorb(2,3));
        
    }    

}
