package calculadora;
import java.util.Scanner;
public class Calculadora {
    public static void main(String[] args) {
        boolean salir=false;
        int b,a;
        Scanner leer=new Scanner(System.in);
        while(salir==false){
            System.out.println("Elige que quieres hacer (+,-,*,/) o introduce 's' para salir");
            char n=leer.next().charAt(0);
            switch(n){
                case '+': 
                    System.out.println("Introduce un número: ");
                    a=leer.nextInt();
                    System.out.println("introduce un número");
                    b=leer.nextInt();
                    System.out.println("La suma es: "+(a+b));
                break;
                case '-': 
                    System.out.println("Introduce un número: ");
                    a=leer.nextInt();
                    System.out.println("introduce un número");
                    b=leer.nextInt();
                    System.out.println("La resta es: "+(a-b));
                break;
                case '*': 
                    System.out.println("Introduce un número: ");
                    a=leer.nextInt();
                    System.out.println("introduce un número");
                    b=leer.nextInt();
                    System.out.println("La multiplicación es: "+(a*b));
                break;
                case '/': 
                    System.out.println("Introduce un número: ");
                    a=leer.nextInt();
                    System.out.println("introduce un número");
                    b=leer.nextInt();
                    System.out.println("La división es: "+(a/b));
                break;
                case 's': salir=true;
                break;
            }
        }
    }
}