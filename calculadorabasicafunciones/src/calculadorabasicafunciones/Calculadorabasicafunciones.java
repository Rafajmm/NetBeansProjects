package calculadorabasicafunciones;
import java.util.*;

public class Calculadorabasicafunciones {

    public static double calculadoraBasca(int a, char o, int b){
        //Sólo funciona con '+', '*' y '/'
        double resultado=0;
        if(o=='+'){
            resultado=a+b;
        }
        if(o=='*'){
            resultado=a*b;
        }
        if(o=='/'){
           if(b==0){
               return 0;
           }
           else{
               resultado=a/b; 
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in),leer2=new Scanner(System.in);
        int a,b;
        char operador;
        
        System.out.println("Introduce el primer numero: ");
        a=leer.nextInt();
        System.out.println("Introduce operador (+, * ó /) ");
        operador=leer2.nextLine().charAt(0);
        System.out.println("Introduce el segundo número: ");
        b=leer.nextInt();
        System.out.println(calculadoraBasca(a,operador,b));
        
        
    }
    
}
