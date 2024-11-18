package comprobardigitos;
import java.util.*;

public class Comprobardigitos {
    public static boolean comprobarDigitos(int a, int b){
        boolean valor=false;
        while(a>0){ //while(b!=a%10)
            if(b==a%10){              
                valor=true;
                a=0;
            }
            a/=10;
        }
        return valor;
        
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce una cifra: ");
        int a=leer.nextInt();
        System.out.println("Introduce el digito a buscar: ");
        int b=leer.nextInt();
        System.out.println(comprobarDigitos(a,b));
        
    
    }
}