package triangulo;
import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        System.out.println("introduce las dimensiones del triangulo a dibujar");
        int n=leer.nextInt(),espacio;
        
        for(int i=0;i<=n;i++){
            espacio=n-i;
            for(int j=0;j<i;j++){
                System.out.print("*");
               
            }
            System.out.println();
        }
            
        
        }
    }
    

