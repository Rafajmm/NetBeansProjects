
package buscardigitos;
import java.util.*;

public class Buscardigitos {
    public static boolean buscarDigito(int a, int b){
        boolean valor=false;
        while(a>0){
            if(b==a%10){              
                valor=true;
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
        System.out.println(buscarDigito(a,b));
    }
    
}
