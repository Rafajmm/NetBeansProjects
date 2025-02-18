package com.mycompany.cifradocesar;
import java.util.*;

public class Cifrar {
    
    private String cadena;
    private int num;
    
    Cifrar(String cadena,int num){
        this.cadena=cadena;
        this.num=num;
    }
    public void setCadena(String cadena){
        this.cadena=cadena;        
    }
    
    public String getCadena(){
        return this.cadena;
    }

    public String cifrar(){
        this.cadena=this.cadena.toLowerCase();
        String cadenaC="";
        char c;
        
        for(int i=0;i<this.cadena.length();i++){
            c=this.cadena.charAt(i);
            if(Character.isLetter(c)){
                if(c>96 && c<=(122-this.num)){
                    c+=this.num;
                    cadenaC+=c;
                }
                else{
                    c=(char)(96+(this.num-(122-c)));
                    cadenaC+=c;
                }
            }
            else{
                cadenaC+=c;
            }
        }
        
        return cadenaC;
    }
    
    public String descifrar(){
        this.cadena=this.cadena.toLowerCase();
        String cadenaC="";
        char c;
        
        for(int i=0;i<this.cadena.length();i++){
            c=this.cadena.charAt(i);
            if(Character.isLetter(c)){
                if(c>96+this.num && c<=122){
                    c-=this.num;
                    cadenaC+=c;
                }
                else{
                    c=(char)(122+(c-(96+this.num)));
                    cadenaC+=c;
                }
            }
            else{
                cadenaC+=c;
            }
        }
        
        return cadenaC;
    }
    
    
    
}
