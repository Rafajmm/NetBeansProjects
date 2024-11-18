package rmarmor406;
import java.util.Scanner;
/**
 *
 * @Rafael Jesús Martínez Moreno
 */
public class Rmarmor406 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(true){
            int i=0,j=0,c=0,c2=0;
            System.out.println("Introduce un número entre 1 y 20. Introduce 0 para detener el programa.");
            int n=leer.nextInt();
            if(n>0 && n<=20){
                int r=(int)((Math.random()*n))+1;
                System.out.print(n+" "+r+" ");
                for(i=0;i<n;i++){
                    System.out.print(c);   
                    c++;
                    if(c>9){
                        c=0;
                    }
                }
                System.out.print("#");
                for(i=0;i<r;i++){
                    System.out.print(c2);
                    c2++;
                    if(c2>9){
                        c2=0;
                    }
                }
            System.out.println(" ");
            }
            if(n<0 || n>20){
                System.out.println("introduce un numero valido");
            }
            if(n==0){
                break;
            }
        }
    }    
}
