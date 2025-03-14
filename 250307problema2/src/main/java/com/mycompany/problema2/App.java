package com.mycompany.problema2;

public class App {

    public static void comparar(Atleta uno, Atleta otro){
        uno=new Atleta("a1",(int)(Math.random()*9999),"fr",Math.random()*15);
        otro=new Atleta("a2",(int)(Math.random()*9999),"it",Math.random()*15);
        double comp=uno.compareTo(otro);
        if(comp<0){
            System.out.println(otro.getNombre());
        }
        else if(comp>0){
            System.out.println(uno.getNombre());
        }
        else{
            System.out.println("Ambos han hecho el mismo tiempo");
        }
    }
    public static void main(String[] args) {
        Atleta a1=new Atleta();
        Atleta a2=new Atleta();
        comparar(a1,a2);
    }
}
