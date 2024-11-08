package ordenarvector;

import java.util.Arrays;


public class OrdenarVector {

    
    public static void main(String[] args) {
        int vector[]=new int[5];
        for(int i=0;i<5;i++){
            vector[i]=(int)(Math.random()*49)+1;
        }
        Arrays.sort(vector);
        System.out.println(Arrays.toString(vector));
    }
    
}
