package ejercicio617;
import java.util.*;

public class Ejercicio617 {

    public static void secuenciasPalabra(String palabra, int n){
        int longitud=palabra.length();
        for(int i=0;i<longitud;i+=n){            
            if(i+n>=longitud){
                System.out.println(palabra.substring(i));
            }
            else{
                System.out.println(palabra.substring(i,i+n));
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in), numero=new Scanner(System.in);
        
        System.out.println("Introduce una palabra ");
        String palabra=leer.next();
        System.out.println("Introduce el número del grupo de letras en la que la quieres dividir");
        int n=numero.nextInt();
        secuenciasPalabra(palabra,n);
    }
    
}
