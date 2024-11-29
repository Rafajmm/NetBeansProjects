package actividad512a;
import java.util.*;
public class Actividad512a {

    public static void desordenar(int vector[]){
        
        for(int i=0;i<vector.length;i++){
            int j=(int)(Math.random()*vector.length);
            int inter=vector[i];
            vector[i]=vector[j];
            vector[j]=inter;
        }
    }
    
    public static void main(String[] args) {
        int vector[]={1,2,3,4,5,6,7,8,9};
        desordenar(vector);
        System.out.println(Arrays.toString(vector));
    }
    
}
