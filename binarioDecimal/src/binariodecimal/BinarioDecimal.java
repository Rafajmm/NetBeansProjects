package binariodecimal;
import java.util.*;

public class BinarioDecimal {

    public static int binarioDecimal(int a){
        int d,r=0,contador=0;
        while(a>0){
            d=(a%10)*(int)(Math.pow(2,contador));
            r+=d;
            contador++;
            a/=10;
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduce un numero binario ");
        int a=leer.nextInt();
        System.out.println(binarioDecimal(a));
    }
   
}