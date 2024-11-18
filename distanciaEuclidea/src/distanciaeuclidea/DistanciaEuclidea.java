package distanciaeuclidea;
import java.util.*;

public class DistanciaEuclidea {
    public static double distanciaEu(double x1,double y1,double x2, double y2){
        double distancia;
        distancia=Math.sqrt(Math.pow(x1-y1,2)+Math.pow(x2-y2,2));
        return distancia;
    }
    
    
    public static long calculoSeg(int dias,int horas,int minutos){
        long segundos=(dias*24*60*60)+(horas*60*60)+(minutos*60);
        return segundos;
    }
    
    
    public static void generarAlea(int parametro,int parametro2,int cantidad){
        int alea,rango=(parametro2+1)-parametro;
        for(int i=0;i<cantidad;i++){
            alea=(int)(Math.random()*rango)+parametro;
            System.out.println(alea);
        }   
    }
    public static int[] generaVector(int parametro, int parametro2, int cantidad){
        int alea,rango=(parametro2+1)-parametro;
        int vector[]=new int[cantidad];
        for(int i=0;i<cantidad;i++){
            alea=(int)(Math.random()*rango)+parametro;
            
            vector[i]=alea;
        } 
        return vector;
    }    
    
    public static void generarAlea(int cantidad){
        double alea;
        for(int i=0;i<cantidad;i++){
            alea=Math.random();
            System.out.println(alea);
        }
    }
    public static double areaRe(int base, int altura){
        double area=base*altura;
        return area;
    }
    
    public static double areaRe(int lado){
        return areaRe(lado,lado);
    }
    
    public static void main(String[] args) {
        double distancia=distanciaEu(4,1,6,2);
        System.out.println(distancia);
        System.out.println(calculoSeg(3,3,3));
        generarAlea(1,9,10);
        generarAlea(10);
        System.out.println(areaRe(3,4));
        System.out.println(areaRe(5));
        System.out.println(Arrays.toString(generaVector(1,9,10)));
        
        
    }
    
}
