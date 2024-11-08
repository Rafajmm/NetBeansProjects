package actividad53modificada;
import java.util.Arrays;
import java.util.Scanner;


public class Actividad53modificada {

    
    public static void main(String[] args) {
        int n=(int)(Math.random()*14)+1;
        int vector[]=new int[n];
        for(int i=0;i<n;i++){
            vector[i]=(int)(Math.random()*51);
        }
        System.out.println(Arrays.toString(vector));
        for(int i=(n-1);i>=0;i--){
            System.out.println(vector[i]);
        }
    }
    
}