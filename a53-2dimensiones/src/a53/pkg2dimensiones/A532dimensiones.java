package a53.pkg2dimensiones;
import java.util.Arrays;


public class A532dimensiones {

     public static void main(String[] args) {
        int n=(int)(Math.random()*14)+1;
        int vector[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            vector[i][j]=(int)(Math.random()*51);
            }
        }
        System.out.println(Arrays.deepToString(vector));
        for(int i=(n-1);i>=0;i--){
            for(int j=0;j<n;j++){
            System.out.println(vector[i][j]);
            }
        }    
    }
    
}