package actividad513;
import java.util.*;

public class Actividad513 {
    
    public static int[] copiaDesordenada(int vector[]){
        int vector2[]=new int[0];
        vector2=Arrays.copyOf(vector, vector.length);
        for(int i=0;i<vector2.length;i++){
            int j=(int)(Math.random()*vector2.length);
            int inter=vector2[i];
            vector2[i]=vector2[j];
            vector2[j]=inter;
        }
        return vector2;
    }
    
    public static void main(String[] args) {
        int vector[]={1,2,3,4,5,6,7,8,9};
        int vector2[]=copiaDesordenada(vector);
        System.out.println(Arrays.toString(vector));
        System.out.println(Arrays.toString(vector2));
        
    }
    
}

