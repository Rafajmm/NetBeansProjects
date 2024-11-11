package ejercicio617clase;
import java.util.Scanner;


public class Ejercicio617Clase {

    public static void secuenciasPalabra(String palabra, int n){
        int longitud=palabra.length();
        boolean salir=false;
        while(salir==false){
            if(palabra.length()<n){
            System.out.println(palabra);
            salir=true;
            }
            else{
                System.out.println(palabra.substring(0,n));
                palabra=palabra.substring(n);
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in), numero=new Scanner(System.in);
        
        System.out.println("Introduce una palabra ");
        String palabra=leer.next();
        System.out.println("Introduce el número del grupo de letras en la que la quieres dividir");
        int n=Math.abs(numero.nextInt());
        secuenciasPalabra(palabra,n);
    }
    
}